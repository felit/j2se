package com.livedrof.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MemoryChannelTest {
    @Test
    public void testChannel() throws IOException {

        String filename = "sss.mmap.txt";
        FileChannel fileChannel = this.getWritableChannel(filename);
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 6);
        // 会把ByteBuffer全部写入文件;即使是空位
        mappedByteBuffer.put("中言".getBytes());
        fileChannel.close();
    }

    private FileChannel getWritableChannel(String filename) throws FileNotFoundException {
        RandomAccessFile file1 = new RandomAccessFile(filename, "rw");
        return file1.getChannel();
    }

    /**
     * FileChannel.open()只读
     * java.nio.channels.NonWritableChannelException
     *
     * @param filename
     * @return
     * @throws IOException
     */
    private FileChannel getReadChannel(String filename) throws IOException {
        Path path = Paths.get(filename);
        File file = path.toFile();
        if (!file.exists()) {
            file.createNewFile();
        }
        return FileChannel.open(path);
    }
}
