package com.shop.ningbaoqi.computernetwork;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClientActivity extends AppCompatActivity {
    public static final int UDP_SERVER_PORT = 20000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String udpMsg = "hello world from UDP client" + UDP_SERVER_PORT;//定义需要发送的信息
                DatagramSocket ds = null;//新建一个DatagramSocket对象
                try {
                    ds = new DatagramSocket();
                    InetAddress serverAddr = InetAddress.getByName("127.0.0.1");//初始化InetAddress对象
                    DatagramPacket datagramPacket = new DatagramPacket(udpMsg.getBytes(), udpMsg.length(), serverAddr, UDP_SERVER_PORT);
                    ds.send(datagramPacket);//发送
                } catch (SocketException e) {//Socket链接异常
                    e.printStackTrace();
                } catch (UnknownHostException e) {//不能连接到主机
                    e.printStackTrace();
                } catch (IOException e) {//数据流异常
                    e.printStackTrace();
                } finally {
                    if (ds != null) {
                        ds.close();
                    }
                }
            }
        }).start();
    }
}
