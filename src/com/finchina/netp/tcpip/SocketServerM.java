package com.finchina.netp.tcpip;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServerM {
    public static void main(String [] args) throws IOException {
        int port = 7000;
        int clientNo = 1;
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService executorService = Executors.newCachedThreadPool();

        while(true){
            Socket socket = serverSocket.accept();
            executorService.execute(new SingleServer(socket,clientNo));
            clientNo ++;
        }
    }
}
