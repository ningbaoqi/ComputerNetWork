package com.shop.ningbaoqi.computernetwork.socket.client;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Socket socket = null;
                try {
                    socket = requestSocket("192.168.1.32", 20000);
                    sendMsg(socket, "how are you");
                    String message = receiveMsg(socket);
                    Log.d("nbq", message);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private String receiveMsg(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = reader.readLine();
        return msg;
    }

    private void sendMsg(Socket socket, String how_are_you) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(how_are_you.replace("\n", " ") + "\n");
        writer.flush();
    }

    private Socket requestSocket(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        return socket;
    }
}
