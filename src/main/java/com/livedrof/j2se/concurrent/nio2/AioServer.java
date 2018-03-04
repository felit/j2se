package com.livedrof.j2se.concurrent.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AioServer {

    public final int port = 8080;
    public final int backlog = 2; //跟bio和nio的backlog其实是一样的。指定accept等待队列的长度
    private AioAcceptHandler acceptHandler;
    private AsynchronousServerSocketChannel serverSocket;

    public static void main(String args[]) throws IOException {
        new AioServer().startup();
    }

    /**
     * availableProcessors: 0
     * channel  Workers: 6
     * channelGroup: 174
     * serverSocket: 1
     * bind: 0
     * acceptHandler: 1
     *
     * @throws IOException
     */
    private void startup() throws IOException {
        long beginTime = System.currentTimeMillis();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long endTime = System.currentTimeMillis();
        System.out.println("availableProcessors:" + (endTime - beginTime));

        beginTime = endTime;
        ExecutorService channelWorkers = Executors.newFixedThreadPool(availableProcessors * 2);
        endTime = System.currentTimeMillis();
        System.out.println("channelWorkers:" + (endTime - beginTime));

        beginTime = endTime;
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withCachedThreadPool(channelWorkers, 1);

        endTime = System.currentTimeMillis();
        System.out.println("channelGroup:" + (endTime - beginTime));
        beginTime = endTime;
        serverSocket = AsynchronousServerSocketChannel.open(channelGroup);

        endTime = System.currentTimeMillis();
        System.out.println("serverSocket:" + (endTime - beginTime));
        beginTime = endTime;
        serverSocket.bind(new InetSocketAddress(port), backlog);

        endTime = System.currentTimeMillis();
        System.out.println("bind:" + (endTime - beginTime));
        beginTime = endTime;
        acceptHandler = new AioAcceptHandler();

        endTime = System.currentTimeMillis();
        System.out.println("acceptHandler:" + (endTime - beginTime));
        this.accept();

    }

    void accept() {
        serverSocket.accept(this, acceptHandler); /*非阻塞*/
    }
}
