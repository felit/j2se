package com.livedrof.nio;

import org.junit.Test;

import java.io.*;

/**
 * 平均每个表的长度，索引相当于列式存储，
 * 30*23=960 10+20 长度是索引的30~100倍；宽表更慢
 * TODO 基本类型写入byte[]??
 */
public class BinaryOutputTest {
    private String filename = "/Users/congsl/work/self/j2se/data.bin";

    @Test
    public void testBinary() throws IOException {
        OutputStream out = new FileOutputStream(filename);
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        for (int i = 0; i < 1000; i++) {
            dataOutputStream.writeLong(Long.valueOf(i));
            dataOutputStream.writeInt((int) Math.round(10 + Math.random() * 20));
            dataOutputStream.writeBytes("world");
        }
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    @Test
    public void testBinaryRead() throws IOException {
        InputStream in = new FileInputStream(filename);
        DataInputStream dataInputStream = new DataInputStream(in);
        for (int i = 0; i < 1000; i++) {
            byte[] bytes = new byte[5];
            System.out.print(i + ": id:" + dataInputStream.readLong() + ",age:" + dataInputStream.readInt());
            dataInputStream.read(bytes);
            System.out.println(",name:" + new String(bytes));
        }
    }

    @Test
    public void testNIORead() {

    }

    @Test
    public void testNIOWrite() {

    }

}
