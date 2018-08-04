package com.shop.ningbaoqi.computernetwork;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPClientActivity extends AppCompatActivity {
    public static final int TCP_SERVER_PORT = 20000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {//在进行网络socket请求的时候，不能在主线程中请求，必须自己开启线程进行TCP链接
            @Override
            public void run() {
                try {
                    Socket socket = new Socket("192.168.1.32", TCP_SERVER_PORT);//初始化socket，注意IP地址 端口号
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取输入流
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//获取输出流
                    String outMsg = "TCP connection to " + TCP_SERVER_PORT + System.getProperty("line.separator");
                    out.write(outMsg);//写入
                    out.flush();//刷新发送
                    String inMsg = in.readLine() + System.getProperty("line.separator");
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
