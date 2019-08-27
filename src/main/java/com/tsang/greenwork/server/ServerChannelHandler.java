package com.tsang.greenwork.server;

import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.service.IEnvEquipService;
import com.tsang.greenwork.service.INumToTcpNumService;
import com.tsang.greenwork.service.IWsInforService;
import com.tsang.greenwork.utils.HEXUtils;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

@Component
@ChannelHandler.Sharable
@Slf4j
public class ServerChannelHandler extends ChannelInboundHandlerAdapter  {

    @Value("${DO.ws1data.read}")
    private String ws1dataRead;
    @Value("${DO.Voltage.read}")
    private String ws2PmRead;
    @Value("${DO.DO-1.open}")
    private String openFan;
    @Value("${DO.DO-1.close}")
    private String shutFan;
    @Value("${DO.DO-2.open}")
    private String openLight;
    @Value("${DO.DO-2.close}")
    private String shutLight;
    @Value("${DO.DO-3.open}")
    private String openWarn;
    @Value("${DO.DO-3.close}")
    private String shutWarn;

    @Autowired
    private INumToTcpNumService iNumToTcpNumService;
    @Autowired
    private IEnvEquipService envEquipService;
    @Autowired
    private IWsInforService IWsInforService;
    @Autowired
    private  Channelmap channelmap;
    /**
     * 拿到传过来的msg数据，开始处理
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */


    //ChannelGroup 是保存channel对象的
    private  static ChannelGroup channelGroup = new
            DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private static final Logger log = LoggerFactory.getLogger(ServerChannelHandler.class);



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {

        System.out.println("接受的数据为:"+msg);
        //对设备返回来的数据 进行数据分析
        int i = envEquipService.dtuTranslate(msg);
        Wsinfor wsinfor = IWsInforService.selectByPrimaryKey("ws001");

        //返回1 自动开启
        if(i==1 & wsinfor.getAutoo().equals("0")){
            byte[] oWarn = HEXUtils.hexStringToByte(openWarn);
            byte[] oFan = HEXUtils.hexStringToByte(openFan);
            byte[] oLight = HEXUtils.hexStringToByte(openLight);
            ByteBuffer buf1 = ByteBuffer.wrap(oWarn);
            ByteBuffer buf2 = ByteBuffer.wrap(oFan);
            ByteBuffer buf3 = ByteBuffer.wrap(oLight);
            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(buf1));
            Thread.sleep(2000);
            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(buf2));
            Thread.sleep(2000);
            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(buf3));
        }
        //返回0  自动关闭
        else if(i == 0){
            byte[] sWarn = HEXUtils.hexStringToByte(shutWarn);
            byte[] sFan = HEXUtils.hexStringToByte(shutFan);
            byte[] sLight = HEXUtils.hexStringToByte(shutLight);
            ByteBuffer buf1 = ByteBuffer.wrap(sWarn);
            ByteBuffer buf2 = ByteBuffer.wrap(sFan);
            ByteBuffer buf3 = ByteBuffer.wrap(sLight);
            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(buf1));
            Thread.sleep(2000);
            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(buf2));
            Thread.sleep(2000);
            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(buf3));
        }
        //返回2 校验正确
        else if(i == 2){
            System.out.println("crc校验正确");
        }
        //返回3 校验错误
        else if(i == 3){
            System.out.println("crc校验错误");
        }else{
            System.out.println("校验错误");
        }
    }

    /**
     * 活跃的、有效的通道
     * 第一次连接成功后进入的方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx)  throws Exception {

           /*
           * 保存channel
           * */
        super.channelActive(ctx);
        log.info("tcp client " + getRemoteAddress(ctx) + " connect success");

        channelmap.CreateChannel(ctx.channel());
        byte[] checkWs2dataRead = HEXUtils.hexStringToByte(ws2PmRead);
        class OD1 implements Runnable {
            @Override
            public void run() {
                ByteBuffer buf1 = ByteBuffer.wrap(checkWs2dataRead);
                while (true) {
                    ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(buf1));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Thread t1 = new Thread(new OD1());
        t1.start();
    }

    //连接建立时回调
    @Override
    public void handlerAdded(ChannelHandlerContext ctx){
        Channel channel = ctx.channel();

        //将会通知到channelGroup里面的所有的channel
        channelGroup.writeAndFlush("【服务器消息】-" + channel.remoteAddress() + "加入\n");
        //将channel放入channelGroup中
        channelGroup.add(channel);

    }

    //连接断开时回调
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
//        channelmap.DeleteChannel(ctx.channel());
        channelGroup.writeAndFlush("【服务器消息】-" + channel.remoteAddress() + "离开\n");
        //这里不需要写channelGroup.remove(channel)移除channel,因为当连接断开时,netty会自动处理
        //这个方法写不写都可以
        //channelGroup.remove(channel);
    }


    /**
     * 不活动的通道
     * 连接丢失后执行的方法（client端可据此实现断线重连）
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //删除Channel Map中的失效Client
        NettyTcpServer.map.remove(getIPString(ctx));
        ctx.close();
        System.out.println(getRemoteAddress(ctx) + "连接断开");
    }

    /**
     * 异常处理
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        //发生异常，关闭连接
        log.error("引擎 {} 的通道发生异常，即将断开连接", getRemoteAddress(ctx));
        ctx.close();//再次建议close
    }

    /**
     * 心跳机制，超时处理
     *
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        String socketString = ctx.channel().remoteAddress().toString();
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                log.info("Client: " + socketString + " READER_IDLE 读超时");
                ctx.disconnect();//断开
            } else if (event.state() == IdleState.WRITER_IDLE) {
                log.info("Client: " + socketString + " WRITER_IDLE 写超时");
                ctx.disconnect();
            } else if (event.state() == IdleState.ALL_IDLE) {
                log.info("Client: " + socketString + " ALL_IDLE 总超时");
                ctx.disconnect();
            }
        }
    }



    /**
     * 获取client对象：ip+port
     *
     * @param ctx
     * @return
     */
    public String getRemoteAddress(ChannelHandlerContext ctx) {
        String socketString = "";
        socketString = ctx.channel().remoteAddress().toString();
        return socketString;
    }

    /**
     * 获取client的ip
     *
     * @param ctx
     * @return
     */
    public String getIPString(ChannelHandlerContext ctx) {
        String ipString = "";
        String socketString = ctx.channel().remoteAddress().toString();
        int colonAt = socketString.indexOf(":");
        ipString = socketString.substring(1, colonAt);
        return ipString;
    }

}