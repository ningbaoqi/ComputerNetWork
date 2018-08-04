package com.shop.ningbaoqi.computernetwork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP服务器代码
 */
public class UDPServer {
    public static final int MAX_UDP_DATAGRAM_LEN = 1024;
    public static final int UDP_SERVER_PORT = 20000;

    public static void main(String[] args) {
        byte[] lMsg = new byte[MAX_UDP_DATAGRAM_LEN];//接收的字节大小，客户端发送的数据不能超过MAX_UDP_DATAGRAM_LEN
        DatagramPacket dp = new DatagramPacket(lMsg, lMsg.length);//实例化一个DatagramPacket
        DatagramSocket ds = null;//新建一个DatagramSocket类
        try {
            ds = new DatagramSocket(UDP_SERVER_PORT);//UDP服务器监听的端口
            ds.receive(dp);//准备接收数据
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();//关闭sd对象
            }
        }
    }
}
