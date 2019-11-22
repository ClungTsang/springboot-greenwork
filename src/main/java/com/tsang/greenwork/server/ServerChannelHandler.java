package com.tsang.greenwork.server;

import com.tsang.greenwork.service.IInsertDBService;
import com.tsang.greenwork.utils.HEXUtils;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * description:
 * author:tsang
 * date: 2019-11-20
 **/
@Component
@ChannelHandler.Sharable
@Slf4j
public class ServerChannelHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    private IInsertDBService iNumToTcpNumService;

    @Value("${DO.FullData.read}")
    private String fullData;

    @Value("${DO.Voltage.read}")
    private String voltageData;

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


private static final Logger logger = LoggerFactory.getLogger(ServerChannelHandler.class);

    /**
     * 拿到传过来的msg数据，开始处理
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if(!"tcpwork001".equals(msg)){
//            String s = String.valueOf(msg);
//            byte[] bytes = s.getBytes(CharsetUtil.UTF_8);
            String tcpData = HEXUtils.bytesToHexString(String.valueOf(msg).getBytes(CharsetUtil.UTF_8));
//            System.out.println("读取到的数据:"+tcpData);
            iNumToTcpNumService.dtuData_InsertDB(tcpData);
        }else{
            System.out.println("注册包:"+msg);
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
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.info("tcp client " + getRemoteAddress(ctx) + " connect success");
        //往channel map中添加channel信息
        NettyTcpServer.map.put(getIPString(ctx),ctx.channel());
        //发送指定数据
//        this.threadRun(ctx,fullData);
    }


    public void threadRun(ChannelHandlerContext ctx,String data){
        byte[] bytes ;
        if("110103000100141405".equals(data)){
            byte[] tmpByte = HEXUtils.hexStringToByte(data);
            //截取下标为1之后的字节数组
            bytes = Arrays.copyOfRange(tmpByte,1,tmpByte.length);
        }else{
            bytes = HEXUtils.hexStringToByte(data);
        }

        class Inner implements Runnable{

            @Override
            public void run() {
                ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
                while (true) {
                    ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(byteBuffer));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Thread thread = new Thread(new Inner());
        thread.start();
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
        logger.error("引擎 {} 的通道发生异常，即将断开连接", getRemoteAddress(ctx));
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
                logger.info("Client: " + socketString + " READER_IDLE 读超时");
                ctx.disconnect();//断开
            } else if (event.state() == IdleState.WRITER_IDLE) {
                logger.info("Client: " + socketString + " WRITER_IDLE 写超时");
                ctx.disconnect();
            } else if (event.state() == IdleState.ALL_IDLE) {
                logger.info("Client: " + socketString + " ALL_IDLE 总超时");
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