package com.nio.game.client;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nio.game.common.codc.RequestEncoder;
import com.nio.game.common.codc.ResponseDecoder;
import com.nio.game.common.model.Request;
import com.nio.game.common.module.fuben.FBData;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
/**
 * netty客户端入门
 * @author -琴兽-
 *
 */
public class Client {

	public static void main(String[] args) throws InterruptedException {
		
		//服务类
		ClientBootstrap bootstrap = new  ClientBootstrap();
		
		//线程池
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		//socket工厂
		bootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));
		
		//管道工厂
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipeline = Channels.pipeline();
				pipeline.addLast("decoder", new ResponseDecoder());
				pipeline.addLast("encoder", new RequestEncoder());
				pipeline.addLast("hiHandler", new HiHandler());
				return pipeline;
			}
		});
		
		//连接服务端
		ChannelFuture connect = bootstrap.connect(new InetSocketAddress("127.0.0.1", 10101));
		Channel channel = connect.sync().getChannel();
		
		System.out.println("client start");
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("请输入");
			int fubenId = Integer.parseInt(scanner.nextLine());
			int count = Integer.parseInt(scanner.nextLine());
			
			//FightRequest fightRequest = new FightRequest();
			//fightRequest.setFubenId(fubenId);
			//fightRequest.setCount(count);
			FBData.Request.Builder builder = FBData.Request.newBuilder();
			builder.setCount(1);
			builder.setFubenId(1);
			FBData.Request build = builder.build();

			Request request = new Request();
			request.setModule((short) 1);
			request.setCmd((short) 1);
			request.setData(build.toByteArray());
			//request.setData(fightRequest.getBytes());
			//发送请求
			channel.write(request);
		}
	}

}
