package com.nio.netty3;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gx
 * @ClassName: Server
 * @Description: java类作用描述
 * @date 2019/4/2 2:22
 * @Version: 1.0
 * @since
 */
public class Server {
    public static void main(String[] args) {
        //服务类
        ServerBootstrap bootstrap=new ServerBootstrap();
        ThreadPoolExecutor boss = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor worker = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());

        bootstrap.setFactory(new NioServerSocketChannelFactory(boss,worker));
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());
                pipeline.addLast("helloHandler",new ServerHandler());
                return pipeline;
            }
        });
        bootstrap.bind(new InetSocketAddress(10000));
    }
}
