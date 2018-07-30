package com.finchina.netp.tcpip;

import java.io.*;
import java.net.Socket;

public class SingleServer implements Runnable {
    private Socket socket;

    private int clientNo;

    public SingleServer(Socket socket, int clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            do{
                double length = dis.readDouble();
                System.out.println("从客户端"+clientNo + "接收到的边长数据为："+length);
                double result = length * length;
                dos.writeDouble(result);
                dos.flush();
            }while(dis.readInt() != 0);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("与客户端" + clientNo +"通信结束！");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
