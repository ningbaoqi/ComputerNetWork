package com.shop.ningbaoqi.computernetwork.socket.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Thread {
    private ServerSocket server = null;
    private static final int PORT = 5000;
    private BufferedWriter writer;
    private BufferedReader reader;

    public ChatServer() throws IOException {
        createSocket();//创建Socket服务器
    }

    private void createSocket() throws IOException {
        server = new ServerSocket(PORT, 100);
    }

    @Override
    public void run() {
        super.run();
        Socket client;
        String txt;//定义接受的文本
        try {
            while (true) {//始终在监听
                client = responseSocket();//开启线程实时监听socket端口，获取应答信息
                while (true) {//响应客户端连接请求
                    txt = receiveMsg(client);
                    System.out.print(txt);//链接获得客户端发来消息，并将其显示在Server端的屏幕上
                    sendMsg(client, txt);//向客户端返回消息
                    if (true) {//中断，继续等待连接请求
                        break;
                    }
                }
                closeSocket(client);//关闭此次连接
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String receiveMsg(Socket client) throws IOException {
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String txt = "Server send:" + reader.readLine();
        return txt;
    }

    private void sendMsg(Socket client, String txt) throws IOException {
        writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        writer.write(txt + "\n");
        writer.flush();
    }

    private void closeSocket(Socket client) throws IOException {
        reader.close();
        writer.close();
        client.close();
    }

    private Socket responseSocket() throws IOException {
        Socket client = server.accept();
        return client;
    }
}
