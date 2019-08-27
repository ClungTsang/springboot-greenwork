package com.tsang.greenwork.server;

import com.tsang.greenwork.server.Deocder.Decoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * description: 通道初始化，主要用于设置各种Handler
 * author:tsag
 * date: 2018-11-28 14:55
 **/
@Component
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    ServerChannelHandler serverChannelHandler;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //IdleStateHandler心跳机制,如果超时触发Handle中userEventTrigger()方法
        pipeline.addLast("idleStateHandler",
                new IdleStateHandler(15, 0, 0, TimeUnit.MINUTES));
        pipeline.addLast(new Decoder());
        // 设置定长字符串接收
        pipeline.addLast(new FixedLengthFrameDecoder(90));
        //字符串编解码器
        /*pipeline.addLast(
                new StringDecoder(),
                new StringEncoder()
        );*/
        //自定义Handler
        pipeline.addLast("serverChannelHandler", serverChannelHandler);
    }
}