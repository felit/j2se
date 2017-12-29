package com.livedrof.j2se.concurrent.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class TestChannelCopy {
    public static void main(String args[]) {
        ReadableByteChannel src = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);

        try {
            copy(src, dest);
//            copyAlt(src, dest);
        } catch (IOException ioe) {
            System.err.println("I/O error: " + ioe.getMessage());
        } finally {
            try {
                src.close();
                dest.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    private static void copy(ReadableByteChannel src, WritableByteChannel dest)
            throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(2048);
        while (src.read(buffer) != -1) {
            buffer.flip();
            dest.write(buffer);
            buffer.compact();
        }
        buffer.flip();
        while (buffer.hasRemaining())
            dest.write(buffer);
    }

    private static void copyAlt(ReadableByteChannel src, WritableByteChannel dest)
            throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(2048);
        while (src.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining())
                dest.write(buffer);
            buffer.clear();
        }
    }
}
