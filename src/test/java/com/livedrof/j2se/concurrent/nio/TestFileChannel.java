package com.livedrof.j2se.concurrent.nio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class TestFileChannel {
    private String filename;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.filename = "/data/source/self/j2se-concurrent/src/test/java/com/livedrof/j2se/concurrent/nio/README2.txt";
    }

    @Test
    public void test() throws IOException {

        RandomAccessFile aFile = new RandomAccessFile(filename, "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);

        String newData = "New String to write to file..." + System.currentTimeMillis() + "\n";
        buf.put(newData.getBytes());
//        buf.flip();
        System.out.println(buf.limit());
        for (int i = 0; i < 10000; i++) {
            buf.rewind();
            inChannel.write(buf);
        }
    }

    /**
     * 确定一下，InputStream会异常：java.nio.channels.NonWritableChannelException
     *
     * @throws IOException
     */
    @Test(expected = NonWritableChannelException.class)
    public void testInputStreamChannel() throws IOException {
        FileInputStream in = new FileInputStream(new File(this.filename));
        ByteBuffer buf = ByteBuffer.allocate(20);
        buf.put("hello".getBytes());
        in.getChannel().write(buf);
    }

    @Test
    public void testOutPutStreamChannel() throws IOException {
        FileOutputStream in = new FileOutputStream(new File(this.filename));
        ByteBuffer buf = ByteBuffer.allocate(20);
        buf.put("hello".getBytes());
        FileChannel channel = in.getChannel();
        Assert.assertTrue(channel instanceof ReadableByteChannel);
        Assert.assertTrue(channel instanceof WritableByteChannel);
        this.exception.expect(NonReadableChannelException.class);
        channel.read(buf);
//        Thread.currentThread().interrupt();
    }
}
