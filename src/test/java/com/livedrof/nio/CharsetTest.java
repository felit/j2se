package com.livedrof.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

/**
 * Charset（字符集）操作: https://blog.csdn.net/qq_17707713/article/details/90243059
 */
public class CharsetTest {
    @Test
    public void test() {
        SortedMap<String, Charset> so = Charset.availableCharsets();
        for (String s : so.keySet()) {
            System.out.println(s + "\t" + so.get(s));
        }
    }

    @Test//字符集操作
    public void Test04() throws CharacterCodingException {
        //创建GBK对应的Charset
        Charset charset = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = charset.newEncoder();

        //创建一个CharBuffer对象
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("我爱学习");
        charBuffer.flip();

        //编码成字节并循环访问
        ByteBuffer bBuf = ce.encode(charBuffer);
        for (int i = 0; i < bBuf.limit(); i++) {
            System.out.print(bBuf.get() + "\t");//GBK一个中文占两个字节
            //-50  -46    -80    -82    -47    -89    -49    -80
        }
        System.out.println("\n------------------------------------------------------");

        //获取解码器
        CharsetDecoder cd = charset.newDecoder();

        //解码后输出
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());//我爱学习

        System.out.println("------------------------------------------------------");

        Charset cs2 = Charset.forName("UTF-8");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());//使用UTF-8解码出现问题
        //�Ұ�ѧϰ
    }

    @Test
    public void ss() {
        // This is the character sequence to encode
        String input = "\u00bfMa\u00f1ana?";
        input = "中文";

// the list of charsets to encode with
        String[] charsetNames = {
                "US-ASCII", "ISO-8859-1", "UTF-8", "UTF-16BE",
                "UTF-16LE", "UTF-16" //, "X-ROT13"
        };
        for (int i = 0; i < charsetNames.length; i++) {
            doEncode(Charset.forName(charsetNames[i]), input);
        }
    }

    private static void doEncode(Charset cs, String input) {
        ByteBuffer bb = cs.encode(input);
        System.out.println("Charset: " + cs.name());
        System.out.println(" Input: " + input);
        System.out.println("Encoded: ");
        for (int i = 0; bb.hasRemaining(); i++) {
            int b = bb.get();
            int ival = ((int) b) & 0xff;
            char c = (char) ival;
// Keep tabular alignment pretty
            if (i < 10) System.out.print(" ");
// Print index number
            System.out.print(" " + i + ": ");
// Better formatted output is coming someday... if (ival < 16) System.out.print ("0");
// Print the hex value of the byte System.out.print (Integer.toHexString (ival)); // If the byte seems to be the value of a
// printable character, print it. No guarantee // it will be.
            if (Character.isWhitespace(c) ||
                    Character.isISOControl(c)) {
                System.out.println("");
            } else {
                System.out.println(" (" + c + ")");
            }
        }
        System.out.println("");
    }
}

