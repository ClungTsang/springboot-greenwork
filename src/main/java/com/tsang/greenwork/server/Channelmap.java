package com.tsang.greenwork.server;

import io.netty.channel.Channel;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Channelmap {

        private  static com.tsang.greenwork.server.Channelmap Channelmap = null;
        private  static Set<Channel> set =new HashSet<>();
        private Channelmap(){
        }

            //单例
        public  static com.tsang.greenwork.server.Channelmap newInstance() {
            if (Channelmap==null)
            {
                Channelmap = newInstance();
            }
                return  Channelmap;
        }

                /*
                * 保存channel
                * */
                public void CreateChannel( Channel channel){
                            //保存到map集合
                            set.add(channel);
                    System.out.println("服务器中共有"+ set.size()+"个clinet");

            }
                        /*
                        * 清除channel
                        * */
            public  void  DeleteChannel(Channel channel){
                            set.remove(channel);
                System.out.println("清除的client"+channel);
            }
            public  Channel GetChannel(){
                    Channel channel2 = null;
                for (Channel channel : set)
                {
                   channel2 =channel;
                }
                return  channel2;
            }
}
