package com.tsang.greenwork.server.Decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class Decoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        byte temByte;
//        System.out.println("数据进入decode..");
//        System.out.println(byteBuf);
        //判断是否有数据
        if (byteBuf.readableBytes() >= 7) {
//            System.out.println("走进完整判断中...");
            //判断数据是否完整
            Integer flag = 0;
            byteBuf.readerIndex(0);
            for(;;) {
                temByte = byteBuf.getByte(flag + 2);
//                System.out.println(bByte);
//                System.out.println("接收到数据...");
                //接收数据
                if ((temByte == 0) || (temByte == 16)) {
                    //十进制  0：00    DO的输入 电压的输入 温湿度pm2.5的输入
                    //十进制 16：10    注册包输入
//                    System.out.println("识别：输入的DO,电压,注册包......");
                    Integer integer = this.judgeData(flag, 8, byteBuf, list);
                    flag = integer;
                }
                else if (temByte == 2) {
                    //十进制 2：02 输出电压
//                    System.out.println("识别：输出的电压......");
                    Integer integer = this.judgeData(flag, 7, byteBuf, list);
                    flag = integer;
                }
//                else if(bByte == 34){
//                    System.out.println("识别：未知的东西......");
//                    Integer integer = this.judgeData(flag, 11, byteBuf, list);
//                    System.out.println("未知的识别完毕");
//                    flag = integer;
//                }
                else if (byteBuf.getByte(1) == 3) {
                    //十进制 1：01 输出温湿度pm2.5
//                    System.out.println("识别：输出的温湿度pm2.5......");
                    Integer integer = this.judgeData(flag, 45, byteBuf, list);
                    flag = integer;
                }
                else {
                    //直接返回10个字节 注册包tcpwork001
//                   System.out.println("识别：输出的注册包......");
                    Integer integer = this.judgeData(flag, 10, byteBuf, list);
//                    System.out.println("注册包识别完毕");
                    flag = integer;
                }
                if(byteBuf.readableBytes() == 0){
                    //没有数据
//                    System.out.println("没有数据.....");
                    byteBuf.clear();
                    return;
                }
            }
        }else{
            //数据不完整 清除并且退出
//            System.out.println("数据不完整 清除并且退出");
            byteBuf.clear();
            return;
        }
    }

    public Integer judgeData(Integer flag ,int i, ByteBuf in, List<Object> list){
//        System.out.println("进入judgeData判断");
        ByteBuf byteBuf = in.readBytes(i);
            list.add(byteBuf);
            flag = in.readerIndex();
//        System.out.println("缓冲区内容已经发送...");
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
//        System.err.println("数据读取完毕");
    }
}

