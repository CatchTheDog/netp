package com.finchina.netp.tcpip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java 网络编程测试
 */
public class SocketServer {
    public static void main(String [] args) throws IOException {
        int port = 7000;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        do{
           double length = dis.readDouble();
           System.out.println("服务端收到的边长数据为："+length);
           double result = length * length;
           dos.writeDouble(result);
           dos.flush();
        }while(dis.readInt() != 0);
        socket.close();
        serverSocket.close();
    }
}
