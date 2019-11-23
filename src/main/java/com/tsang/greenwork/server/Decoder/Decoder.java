package com.tsang.greenwork.server.Decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class Decoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        byte temByte;
        //判断是否有数据
        if (byteBuf.readableBytes() >= 7) {
            //判断数据是否完整
            Integer flag = 0;
            byteBuf.readerIndex(0);
            for(;;) {
                temByte = byteBuf.getByte(flag + 2);
                //接收数据
                if ((temByte == 0) || (temByte == 16)) {
                    //十进制  0：00    DO的输入 电压的输入 温湿度pm2.5的输入
                    //十进制 16：10    注册包输入
                    Integer integer = this.judgeData(flag, 8, byteBuf, list);
                    flag = integer;
                }
                else if (temByte == 2) {
                    //十进制 2：02 输出电压
                    Integer integer = this.judgeData(flag, 7, byteBuf, list);
                    flag = integer;
                }
                else if (byteBuf.getByte(1) == 3) {
                    //十进制 1：01 输出温湿度pm2.5
                    Integer integer = this.judgeData(flag, 45, byteBuf, list);
                    flag = integer;
                }
                else {
                    //直接返回10个字节 注册包tcpwork001
                    Integer integer = this.judgeData(flag, 10, byteBuf, list);
                    flag = integer;
                }
                if(byteBuf.readableBytes() == 0){
                    //没有数据
                    byteBuf.clear();
                    return;
                }
            }
        }else{
            byteBuf.clear();
            return;
        }
    }

    public Integer judgeData(Integer flag ,int i, ByteBuf in, List<Object> list){
        ByteBuf byteBuf = in.readBytes(i);
            list.add(byteBuf);
            flag = in.readerIndex();
            return flag;
        }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}

