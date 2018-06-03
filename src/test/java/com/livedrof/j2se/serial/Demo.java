package com.livedrof.j2se.serial;

import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

/**
 */
public class Demo implements Serializable {

    private int age = 10;
    private String filename = "/data/source/self/j2se-concurrent/src/test/Demo.serial";

    @Test
    public void testOutput() throws IOException {
        Demo demo = new Demo();
        OutputStream fileOutputStream = new FileOutputStream(new File(filename));
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(demo);
        out.flush();
        out.close();
    }

    @Test
    public void testInput() throws IOException, ClassNotFoundException {
        InputStream fileInputStream = new FileInputStream(new File(filename));
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Object result = inputStream.readObject();
        System.out.println(result.getClass());
    }

    @Test
    public void testInt() {
        System.out.println(1 == new Integer(1));
        System.out.println(Arrays.stream(new int[]{1,2,3,4}).anyMatch(o -> o == new Integer(3)));

    }
}
