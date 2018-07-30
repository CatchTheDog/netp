package com.finchina.netp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class DaytimeUdpServer {

    private final static int PORT = 13;

    public static void main(String [] args){
        try(DatagramSocket datagramSocket = new DatagramSocket(PORT)){
            while(true){
                DatagramPacket request = new DatagramPacket(new byte[1024],1024);
                datagramSocket.receive(request);
                String dayTime = new Date().toLocaleString();
                byte [] data = dayTime.getBytes("ASCII");
                DatagramPacket response = new DatagramPacket(data,data.length,request.getAddress(),request.getPort());
                datagramSocket.send(response);
                System.out.println(dayTime + " " + request.getAddress());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
