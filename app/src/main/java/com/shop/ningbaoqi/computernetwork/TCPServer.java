package com.shop.ningbaoqi.computernetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 服务器端
 */
public class TCPServer {
    public static final int TCP_SERVER_PORT = 20000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;//创建一个ServerSocket对象
        try {
            serverSocket = new ServerSocket(TCP_SERVER_PORT);//指定绑定的端口
            Socket socket = serverSocket.accept();//监听连接请求
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取输入流
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//获取输出流
            String inComingMsg = in.readLine() + System.getProperty("line.separator");//接收信息，转化成字符串
            String outGoingMsg = "goodbye from port" + TCP_SERVER_PORT + System.getProperty("line.separator");//生成发送字符串
            out.write(outGoingMsg);//发送消息传入到输出流中
            out.flush();//刷新 发送
            socket.close();//关闭
        } catch (InterruptedIOException exception) {
            exception.printStackTrace();//超时错误
        } catch (IOException e) {
            e.printStackTrace();//IO错误
        } finally {
            if (serverSocket != null) {//判断是否初始化ServerSocket对象，如果初始化则关闭ServerSocket
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
