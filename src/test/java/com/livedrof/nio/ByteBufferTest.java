package com.livedrof.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * byte[]、ByteBuffer、CharBuffer、CharSequence、String、Charset、Pattern、Matcher
 */
public class ByteBufferTest {
    @Test
    public void testWrite() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
//        byteBuffer.
    }

    @Test
    public void testByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024);
        byte bb = 0x1F;
        byteBuffer.put(bb);
    }

    /**
     * String->encode->ByteBuffer
     * ByteBuffer->decode->String
     */
    @Test
    public void testCharset() {
        // 创建GBK字符集对象
        Charset charset = Charset.forName("GBK");
        // 将字符串序列转为字节序列
        ByteBuffer byteBuffer = charset.encode("天空sky");
        // 将字节序列转为字符序列
        CharBuffer charBuffer = charset.decode(byteBuffer);

        String str = charBuffer.toString();

        System.out.println(charBuffer.get());
        System.out.println(str);
    }

    @Test
    public void testPattern() {
        Pattern pattern = Pattern.compile("(hello)");
        Matcher matcher = pattern.matcher("hello world");
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.groupCount());
        }
    }
}
