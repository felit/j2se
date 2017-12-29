package com.livedrof.j2se.concurrent.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AioAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

    @Override
    public void completed(AsynchronousSocketChannel socket, AioServer aioServer) {
        try {
            System.out.printf("客户端%s连接成功.\n", socket.getRemoteAddress().toString());
            readData(socket);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                socket.close();
            } catch (IOException e1) {
            }
        } finally {
            aioServer.accept();
        }
    }

    private void readData(AsynchronousSocketChannel socket) {
        ByteBuffer buf = ByteBuffer.allocate(32);   //测试时，可以不设置太大，观察aio的多次read
        socket.read(buf, buf, new AioReadHandler(socket));
    }

    @Override
    public void failed(Throwable throwable, AioServer aioServer) {
        throwable.printStackTrace();
    }
}
