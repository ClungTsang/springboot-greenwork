package com.tsang.greenwork.server.Deocder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.tomcat.util.buf.HexUtils;

import java.util.List;

public class Decoder extends ByteToMessageDecoder {

            //解码器
    @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {


//            System.out.println(in.toString(Charset.forName("utf-8")));
            /*if (in.readableBytes()==1196){
                Integer flag2=546;
                in.readerIndex(546);
                while (in.readableBytes() > 0)
                {

                    firstbytes = in.getByte(flag2);

                    //辨别m 设备
                    if (firstbytes == 109) {
                        if(in.readableBytes()<13){
                            return;
                        }else{
                            byteBuf = in.readBytes(13);
                            flag2 = in.readerIndex();
                            out.add(byteBuf);
                            System.out.println();
                        }
                    }

                    //辨别w  车间
                    if (firstbytes == 119) {
                        if(in.readableBytes()<13){
                            return;
                        }else {
                            byteBuf = in.readBytes(13);
                            flag2 = in.readerIndex();
                            out.add(byteBuf);
                        }
                    }
                }
                in.clear();
                return;

            }

            while (in.readableBytes() > 0)
            {
                firstbytes = in.getByte(flag);

                if(firstbytes == 48 | firstbytes == 49){
                    if(in.readableBytes()<17){
                        return;
                    }else{
                        System.out.println("16进制:"+in.readBytes(17).toString(Charset.forName("utf-8")));
                        byteBuf = in.readBytes(17);
                        flag = in   .readerIndex();
                        out.add(byteBuf);
                    }
                }
                if(firstbytes == 116){
                    //116 t 辨别注册包
                    if(in.readableBytes()<21){
                        return ;
                    }
                    else{
                        System.out.println("注册包为:"+in.readBytes(10).toString(Charset.forName("utf-8")));
                        firstbytes = in.getByte(in.readerIndex());
                        while(firstbytes == 119){
                            byteBuf = in.readBytes(16);


                            flag = in.readerIndex();
                            System.out.println("插入的数据为:"+byteBuf.toString(Charset.forName("utf-8")));
                            out.add(byteBuf);
                            firstbytes = in.getByte(flag);
                        }
                        in.clear();
                        }
                    }

                if (firstbytes == 109) {
                //辨别m 设备

                    if(in.readableBytes()<13){
                        return;
                    }else {
                        byteBuf = in.readBytes(13);
                        flag = in.readerIndex();
                        out.add(byteBuf);
                    }
                }

                    if (firstbytes == 119) {
                        //辨别w  车间
                    if(in.readableBytes()<13){
                        return;
                    }else {
                        byteBuf = in.readBytes(13);
                        flag = in.readerIndex();
                        out.add(byteBuf);
                    }
                }
            }
            in.clear();
            */

//        int i = in.readableBytes();

        if (in.readableBytes()==10){
//        out.add(in.readBytes(in.readableBytes()).toString(Charset.forName("UTF-8")));
        //out.add(in.readBytes(in.readableBytes()));
        in.clear();
        return;
        }


        byte[] bytes =new byte[in.readableBytes()];
//        System.out.println("in"+in.readableBytes());
        in.writeBytes(bytes);
//        System.out.println("bytes"+bytes.length);
//        System.out.println(in.getBytes(0,bytes));
        String s = HexUtils.toHexString(bytes);
//        System.out.println(s);
        out.add(s);
        in.clear();
    }
}

