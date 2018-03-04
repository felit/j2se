package com.livedrof.j2se.concurrent.nio2.otherAio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 *  TODO 是否涉及拆包解包问题？
 *  channel的read/write操作会出现哪些异常？
 */
public class AsyncServerHandler {
    AsynchronousServerSocketChannel channel;

    public AsyncServerHandler() throws IOException {
        /**
         * TODO channel会启动多个线程，默认是10个
         */
        this.channel = AsynchronousServerSocketChannel.open();
        this.channel.bind(new InetSocketAddress(8090));
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        new AsyncServerHandler().accept();
    }

    public void accept() {
        try {
            /**
             * attachment是做什么的？：an object attached to the I/O operation to provide context when consuming the result
             * 提供返回结果时，需要的环境信息
             * 注意其引起的异常：
             */
            this.channel.accept(this, new AcceptHandler());
            /**
             * 线程不阻塞，怎么处理？
             */
            System.out.println("服务器已启动，端口号：8090");
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncServerHandler> {

        @Override
        public void completed(AsynchronousSocketChannel channel, AsyncServerHandler attachment) {
//            TODO 为什么会重复执行accept方法？
            attachment.channel.accept(attachment, this);
            ByteBuffer buffer = ByteBuffer.allocate(16);
            channel.read(buffer, buffer, new ReadHandler(channel));
        }

        @Override
        public void failed(Throwable exc, AsyncServerHandler attachment) {
            exc.printStackTrace();
        }
    }

    static class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {
        //用于读取半包消息和发送应答?
        private AsynchronousSocketChannel channel;

        public ReadHandler(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }


        /**
         * 操作完成之后，即读操作完成之后。
         * @param result
         * @param attachment
         */
        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            attachment.flip();
            byte[] message = new byte[attachment.remaining()];
            attachment.get(message);
            try {
                String content = new String(message, "UTF-8");
                System.out.println("当前线程名称：" + Thread.currentThread().getName());
                System.out.println("服务器收到消息：" + content);
                doWrite("返回结果：" + content);
                System.out.println("-------------------------");
//                Thread.dumpStack();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {

        }

        private void doWrite(String result) {
            byte[] bytes = result.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            System.out.println("输出值：");
            System.out.println("-------- 分隔线开始 ---------");
            System.out.println(result);
            System.out.println("-------- 分隔线结束 ---------");
            /**
             * CompletionHandler<V,A>
             *     V: 表示I/O操作的返回类型
             *     A：The type of the object attached to the I/O operation
             */
            channel.write(writeBuffer, null, new CompletionHandler<Integer, ByteBuffer>() {
                /**
                 * 写完之后的回调
                 * @param result
                 * @param attachment
                 */
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("返回结果线程名称：" + Thread.currentThread().getName());
                    System.out.println("result:" + result);
                    System.out.println("attachment:" + attachment);
//                    if (attachment.hasRemaining()) {
//                        channel.write(writeBuffer, writeBuffer, this);
//                    } else {
//                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                        channel.read(byteBuffer, byteBuffer, new ReadHandler(channel));
//                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}
