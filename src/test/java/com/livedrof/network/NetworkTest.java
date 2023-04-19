package com.livedrof.network;

import org.junit.Test;

import java.net.*;
import java.util.Enumeration;

public class NetworkTest {
    @Test
    public void testAddress() throws UnknownHostException {
//        InetAddress address =  InetAddress.getByAddress("www.baidu.com","127.0.0.1".getBytes());
        InetAddress address = InetAddress.getByAddress("www.baidu.com", new byte[]{(byte) 192, (byte) 168, 0, 1});
        System.out.println(address.getHostName());
        InetSocketAddress socketAddress = new InetSocketAddress(address, 8009);
        System.out.println(socketAddress.getHostString());
    }

    @Test
    public void testNetworkInterface() throws SocketException {
        Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()) {
            printNetworkInterface(networkInterface.nextElement());
        }
    }

    private void printNetworkInterface(NetworkInterface in) throws SocketException {
        StringBuffer sb = new StringBuffer();
        sb.append("name:" + in.getName()
                + ",\tdisplayName:" + in.getDisplayName()
                + ",\tindex:" + in.getIndex()
                + ",\tmtu:" + in.getMTU()
                + ",\thardwareAddress:" + in.getHardwareAddress()
//                + ",\thardwareAddress:" + networkInterface.getHardwareAddress() != null ? new String(networkInterface.getHardwareAddress()) : "null"
                + "\n");
        System.out.println(sb);
    }

    @Test
    private void testURI() {
        //TODO
    }
}
