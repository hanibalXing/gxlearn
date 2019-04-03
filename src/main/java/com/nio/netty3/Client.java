package com.nio.netty3;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gx
 * @ClassName: Client
 * @Description: java类作用描述
 * @date 2019/4/2 12:05
 * @Version: 1.0
 * @since
 */
public class Client {
    public static void main(String[] args) {
        ClientBootstrap clientBootstrap=new ClientBootstrap();
        ThreadPoolExecutor boss = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor worker = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());

        clientBootstrap.setFactory(new NioClientSocketChannelFactory(boss,worker));
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());
                pipeline.addLast("helloHandler",new ClientHandler());
                return pipeline;
            }
        });
        ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 10000));
        Channel channel = connect.getChannel();
        Scanner scanner=new Scanner(System.in);
        while (true) {
            String sendMessage = scanner.next();
            channel.write(sendMessage);
            if("bye".equals(sendMessage)) {
                connect.cancel();
                channel.close();
            }
        }
    }

}
