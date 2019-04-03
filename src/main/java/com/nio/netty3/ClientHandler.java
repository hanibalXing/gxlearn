package com.nio.netty3;

import lombok.extern.slf4j.Slf4j;
import org.jboss.netty.channel.*;

/**
 * @author gx
 * @ClassName: ServerHandler
 * @Description: java类作用描述
 * @date 2019/4/2 2:28
 * @Version: 1.0
 * @since
 */
@Slf4j
public class ClientHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        /*ChannelBuffer message = (ChannelBuffer)e.getMessage();
        log.info("message is {}",new String(message.array()));*/
        String message = (String) e.getMessage();
        log.info("message is {}",message);
     /*   ChannelBuffer channelBuffer = ChannelBuffers.copiedBuffer("hi".getBytes());
        ctx.getChannel().write(channelBuffer);*/
        //ctx.getChannel().write("yes");
        super.messageReceived(ctx, e);
    }


    /**
     * 异常触发
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {

        super.exceptionCaught(ctx, e);
    }

    /**
     * 连接成功触发
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        log.info("connect");
        super.channelConnected(ctx, e);


    }

    /**
     * 比须连接成功后才会触发
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        log.info("disconnect");
        super.channelDisconnected(ctx, e);
    }

    /**
     * 连接不成功也会触发
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        log.info("close");
        super.channelClosed(ctx, e);
    }
}
