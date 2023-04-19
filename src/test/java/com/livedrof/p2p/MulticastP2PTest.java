package com.livedrof.p2p;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastP2PTest {
    private int port = 5555;
    private String hostname = "238.2.0.1";

    @Test
    public void testListener() throws UnknownHostException {
        InetAddress group = InetAddress.getByName(hostname);
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);//加入到组播组
            byte[] buffer = new byte[8192];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                ms.receive(packet);//接收组播数据报
                String s = new String(packet.getData(), 0, packet.getLength());
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @Test
    public void testSend() throws UnknownHostException {
        InetAddress group = InetAddress.getByName(hostname);
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);//加入到组播组
            while (true) {
                String message = "Hello " + new java.util.Date();
                byte[] buffer = message.getBytes();
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length, group, port);
                ms.send(dp);//发送组播数据报
                System.out.println("发送数据报给" + group + ":" + port);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException e) {
                }

            }
        }
    }
}
