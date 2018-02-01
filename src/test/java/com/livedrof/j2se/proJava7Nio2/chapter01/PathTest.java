package com.livedrof.j2se.proJava7Nio2.chapter01;

import org.junit.Test;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * File system: stores and organizes files on some form of media, generally one or more hard drives, in such a way that they can be easily retrieved.
 *
 * URI Path
 * 1、Data in memory
 * 2、on the network
 * 3、on a virtual file system
 *
 * FileSystems/FileSystem Paths/Path
 * Because Path is basically a string, the referenced resource might not exist.
 */
public class PathTest {
    @Test
    public void test() {
        System.out.println(FileSystems.getDefault());;
//        FileSystems.getFileSystem()
        System.out.println(Paths.get("index.html"));
        System.out.println(Paths.get("index.html").getFileSystem());
        System.out.println(Paths.get("http://www.livedrof.com/"));
        Path path = Paths.get(System.getProperty("user.home"));
        for (int i = 0; i < path.getNameCount(); i ++) {
            System.out.println(path.getName(i).getFileName());
        }


    }
}
