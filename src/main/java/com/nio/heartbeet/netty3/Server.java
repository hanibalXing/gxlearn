package com.nio.heartbeet.netty3;

import java.net.InetSocketAddress;
import java.util.concurrent.*;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.handler.timeout.IdleStateHandler;
import org.jboss.netty.util.HashedWheelTimer;
/**
 * netty服务端入门
 * @author -琴兽-
 *
 */
public class Server {

	public static void main(String[] args) {

		//服务类
		ServerBootstrap bootstrap = new ServerBootstrap();
		
		//boss线程监听端口，worker线程负责数据读写
		ThreadPoolExecutor boss = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
				60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
		ThreadPoolExecutor worker = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
				60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
		
		//设置niosocket工厂
		bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
		
		final HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();
		//设置管道的工厂
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {

				ChannelPipeline pipeline = Channels.pipeline();
				pipeline.addLast("idle", new IdleStateHandler(hashedWheelTimer, 5, 5, 10));
				pipeline.addLast("decoder", new StringDecoder());
				pipeline.addLast("encoder", new StringEncoder());
				pipeline.addLast("helloHandler", new HelloHandler());
				return pipeline;
			}
		});
		
		bootstrap.bind(new InetSocketAddress(10000));
		
		System.out.println("start!!!");
		
	}

}
