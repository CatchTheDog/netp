package com.finchina.netp.urlip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String [] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);
        inetAddress = InetAddress.getByName("wwww.baidu.com");
        System.out.println(inetAddress);
    }
}
