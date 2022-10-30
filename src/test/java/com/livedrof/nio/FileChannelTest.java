package com.livedrof.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class FileChannelTest {
    public static void main(String args[]) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("/Users/congsl/work/self/j2se/src/main/java/com/livedrof/nio/FileChannelTest.java", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        System.out.println(inChannel.size());
        //out put
        String newData = "time" + new Date();
        ByteBuffer bufForWrite = ByteBuffer.allocate(256);
        bufForWrite.clear();
        bufForWrite.put(newData.getBytes());
        bufForWrite.flip();
        File file = new File("/Users/congsl/work/self/j2se/src/main/java/com/livedrof/nio/FileChannelTest.txt");
        FileOutputStream fio = new FileOutputStream(file);
        FileChannel outChanel = fio.getChannel();
        outChanel.write(bufForWrite);
//        outChanel.force(true);
//        outChanel.close();
    }
}
