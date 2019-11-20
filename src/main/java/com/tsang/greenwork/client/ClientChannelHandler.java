package com.tsang.greenwork.client;


import com.tsang.greenwork.service.IRandomNumService;
import com.tsang.greenwork.utils.HEXUtils;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

/**
 * description:
 * author: tsag
 * date: 2018-12-28 14:06
 **/
@Component
@ChannelHandler.Sharable
public class ClientChannelHandler extends SimpleChannelInboundHandler<Object> {
    @Autowired
    private IRandomNumService iRandomNumService;



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
    /**
     * 从服务器接收到的msg
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {



    }
    @Override
    /**
     *
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        for(int i = 0 ; i <1000; i++) {
//            for (int n = 0; n < 2; n++) {
//                StringBuilder stringBuilder = iRandomNumService.PickMachNum();
////                System.out.println("client1"+stringBuilder+new Date());
//                ctx.channel().writeAndFlush(stringBuilder).syncUninterruptibly();
//                Thread.sleep(5*60*1000);
////
//            }
//            StringBuilder stringBuilder1 = iRandomNumService.PickWsNum();
//            StringBuilder stringBuilder2 = iRandomNumService.PickMachNum();
//            StringBuilder s = stringBuilder2.append(stringBuilder1);
////            System.out.println("client发送数据"+s+new Date());
//            ctx.channel().writeAndFlush(s).syncUninterruptibly();
//            Thread.sleep(5*60*1000);
//        }

        this.threadRun(ctx,openLight);
        this.threadRun(ctx,shutLight);

    }
    public void threadRun(ChannelHandlerContext ctx,String data){

        byte[] bytes = HEXUtils.hexStringToByte(data);

        class Inner implements Runnable{

            @Override
            public void run() {
                ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
                while (true) {
                    ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(byteBuffer));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Thread thread = new Thread(new Inner());
        thread.start();

    }
}