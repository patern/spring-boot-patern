/**
 * 
 */
package com.patern.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * @author Administrator
 *
 */
public class DiscardServerHandler extends ChannelHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
    	 ByteBuf in = (ByteBuf) msg;
    	    try {
//    	    	 System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
//    	        while (in.isReadable()) { // (1)
//    	            System.out.print((char) in.readByte());
//    	            System.out.flush();
//    	        }
    	    	ctx.writeAndFlush(msg);
    	    } finally {
//    	        ReferenceCountUtil.release(msg); // (2)
    	    }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}