package com.finchina.netp.udp;

import java.io.IOException;
import java.net.*;

public class DaytimeUdpClient {
    private static final int PORT = 13;
    private static final String HOST_NAME = "localhost";

    public static void main(String [] args){
        //传入0表示让操作系统分配一个端口号
        try(DatagramSocket datagramSocket = new DatagramSocket(0)){
            datagramSocket.setSoTimeout(10000);
            InetAddress host = InetAddress.getByName(HOST_NAME);
            //指定包要发送的目的地
            DatagramPacket request = new DatagramPacket(new byte[1],1,host,PORT);
            //为接收到的数据包创建空间
            DatagramPacket response = new DatagramPacket(new byte[1024],1024);
            datagramSocket.send(request);
            datagramSocket.receive(response);
            String result = new String(response.getData(),0,response.getLength(),"ASCII");
            System.out.println(result);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
