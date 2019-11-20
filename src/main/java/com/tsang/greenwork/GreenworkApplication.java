package com.tsang.greenwork;

import com.tsang.greenwork.client.NettyTcpClient;
import com.tsang.greenwork.controller.EnvEquipController;
import com.tsang.greenwork.server.NettyTcpServer;
import com.tsang.greenwork.server.ServerChannelHandler;
import com.tsang.greenwork.service.impl.EnvEquipImpl;
import com.tsang.greenwork.service.impl.WsInforServiceImpl;
import io.netty.channel.ChannelFuture;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("com.tsang.greenwork.mapper")
@SpringBootConfiguration
@EnableScheduling
@EnableCaching
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class GreenworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GreenworkApplication.class, args);
    }
    @Autowired
    NettyTcpServer nettyTcpServer;
    @Autowired
    NettyTcpClient nettyTcpClient;
    @Autowired
    WsInforServiceImpl wsInforService;
    @Autowired
    EnvEquipImpl envEquipService;
    @Autowired
    EnvEquipController envEquipController;
    @Autowired
    ServerChannelHandler serverChannelHandler;
    @Override
    public void run(String... args) throws Exception{
        //启动定时器 每天格式化车间修复状态
//        wsInforService.updateUnfixStatus();

        //启动服务端
        ChannelFuture start = nettyTcpServer.start();

        //启动客户端
//        nettyTcpClient.connect();

        //服务端管道关闭的监听器并同步阻塞 知道channel关闭 线程才会往下执行 结束进程
        start.channel().closeFuture().syncUninterruptibly();

    }

}
