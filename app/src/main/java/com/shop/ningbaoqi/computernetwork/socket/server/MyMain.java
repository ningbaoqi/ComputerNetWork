package com.shop.ningbaoqi.computernetwork.socket.server;

import java.io.IOException;

public class MyMain {
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        if (chatServer != null) {
            chatServer.start();
        }
    }
}
