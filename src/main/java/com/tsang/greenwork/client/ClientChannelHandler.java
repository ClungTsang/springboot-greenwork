package com.tsang.greenwork.client;


import com.tsang.greenwork.service.IRandomNumService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
    @Value("${DO.ws1data.read}")
    private String ws1dataRead;
    @Value("${DO.Voltage.read}")
    private String ws2PmRead;
    /**
     * 从服务器接收到的msg
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("接受到服务器返回的数据"+msg);
    }

    @Override
    /**
     *
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {


//        while(true) {
//            for (int n = 0; n < 2; n++) {
//                StringBuilder stringBuilder = iRandomNumService.PickMachNum();
////                byte[] bytes = HEXUtils.hexStringToByte((String.valueOf(stringBuilder)));
////                ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(bytes)).syncUninterruptibly();
//                ctx.channel().writeAndFlush(stringBuilder).syncUninterruptibly();
//                Thread.sleep(5*60*1000);
//            }
//            StringBuilder stringBuilder1 = iRandomNumService.PickWsNum();
//            StringBuilder stringBuilder2 = iRandomNumService.PickMachNum();
//            StringBuilder s = stringBuilder2.append(stringBuilder1);
////            byte[] bytes = HEXUtils.hexStringToByte((String.valueOf(s)));
////            ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(bytes)).syncUninterruptibly();
//            ctx.channel().writeAndFlush(s).syncUninterruptibly();
//            Thread.sleep(5*60*1000);
//        }
    }
}

