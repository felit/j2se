package com.livedrof.j2se.concurrent.nio2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

public class AioReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socket;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    public AioReadHandler(AsynchronousSocketChannel socket) {
        this.socket = socket;
    }

    @Override
    public void completed(Integer result, ByteBuffer buf) {
        System.out.println("result = " + result + " buf = " + buf);
        if (result > 0) {
            buf.flip();
            try {
                baos.write(buf.array());
            } catch (IOException e) {
                e.printStackTrace();
            }
            buf.clear();
            socket.read(buf, buf, this);
        } else if (result == -1) { //result为-1的时候，客户端的socket已经正常关闭。
            try {
                System.out.printf("客户端%s已经断开.\n", socket.getRemoteAddress().toString());
                String info = new String(baos.toByteArray(), Charset.forName("UTF8"));
                System.out.println(info);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                buf = null;
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @Override
    public void failed(Throwable throwable, ByteBuffer byteBuffer) {
        throwable.printStackTrace();
    }
}
