package com.livedrof.p2p;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * P2P有多种模式：
 * 1、哪些协议是以UDP为基础的？
 */
public class P2pTest {
    private int port = 1234;
    private String hostname = "228.5.6.7";

    @Test
    public void testListener() throws IOException {
        byte[] data = new byte[256];

        InetAddress ip = InetAddress.getByName(hostname);
        MulticastSocket ms = new MulticastSocket(port);
        try {
            ms.joinGroup(ip);
            System.out.println("receive beginning");
            while (true) {
                DatagramPacket packet = new DatagramPacket(data, data.length);
                ms.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ms.close();
            ms.leaveGroup(ip);
            System.out.println("receive completely");
        }
    }

    @Test
    public void testSender() {
        String data = "Hello Multicast";

        try {
            InetAddress ip = InetAddress.getByName(hostname);
            MulticastSocket ms = new MulticastSocket(port);
            ms.joinGroup(ip);
            System.out.println(data);
            for (int i = 0; i < 100; i++) {
                DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(), ip, port);
                ms.send(packet);
            }
            ms.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
