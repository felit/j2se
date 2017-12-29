package com.livedrof.j2se.concurrent.nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Buffer的用户是Channel与应用
 */

public class TestBuffer {
    @Test
    public void test() {
//        Buffer定义外部接口与语义
        ByteBuffer buffer = ByteBuffer.allocate(7);
        buffer.putInt(200);
        System.out.println(buffer);
//        buffer.array();
    }
}
