package com.livedrof.j2se.concurrent.jmm;

public class Synchronized {
    public static void main(String args[]) {
        synchronized (Synchronized.class) {

        }
        m();
    }
    public static synchronized void m() {

    }
}
