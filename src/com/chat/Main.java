package com.chat;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        int port = 10000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while(true){
                System.out.println("연결 대기중");
                Socket socket = serverSocket.accept();

                System.out.println("연결요청 수락" + socket.getInetAddress());

                //데이터 전송
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("hello");
                System.out.println("데이터 전송 끝");

                dos.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
