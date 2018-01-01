package com.livedrof.j2se.concurrent.jmm;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String args[]) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
//        out.connect(in);
        in.connect(out);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {

                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                /**
                 java.io.IOException: Pipe not connected
                 at java.io.PipedReader.read(PipedReader.java:235)
                 at com.livedrof.j2se.concurrent.jmm.Piped$Print.run(Piped.java:37)
                 at java.lang.Thread.run(Thread.java:745)
                 */
                while (((receive = in.read()) != -1)) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
