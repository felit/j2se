package com.livedrof.j2se.concurrent.nio2;

import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    @Test
    public void test() {
        Path p = Paths.get("/home/congsl/books/nio/OReilly - Java NIO.pdf");
        System.out.println(p);
        FileSystems.getDefault();
    }
}
