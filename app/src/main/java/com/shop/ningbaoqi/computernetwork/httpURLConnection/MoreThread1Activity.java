package com.shop.ningbaoqi.computernetwork.httpURLConnection;

//断点续传的原理就是记录各线程下载的位置，然后下次下载的时候直接在这个记录的位置上开始

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoreThread1Activity extends AppCompatActivity {
    private static String FILENAME = "sb.mp4";
    private static String PATH = "http://192.168.188.41:8080/" + FILENAME;
    private static int THREADCOUNT = 3;
    private static int FINISHEDTHREAD = 0;
    private ProgressBar progressBar;
    private static int currentProgress = 0;
    private TextView textView = null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            textView.setText((long) progressBar.getProgress() * 100 / progressBar.getMax() + "%");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morethread1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.persent);
    }

    public void download(View view) {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(PATH);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    if (connection.getResponseCode() == 200) {
                        int length = connection.getContentLength();
                        progressBar.setMax(length);
                        File file = new File(getExternalCacheDir(), FILENAME);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                        randomAccessFile.setLength(length);
                        randomAccessFile.close();
                        int size = length / THREADCOUNT;
                        for (int i = 0; i < THREADCOUNT; i++) {
                            int startIndex = i * size;
                            int endIndex = (i + 1) * size - 1;
                            if (i == THREADCOUNT - 1) {
                                endIndex = length - 1;
                            }
                            new DownLoadThread(startIndex , endIndex , i).start();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    class DownLoadThread extends Thread {
        int startIndex;
        int endIndex;
        int threadID;

        public DownLoadThread(int startIndex, int endIndex, int threadID) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.threadID = threadID;
        }
        @Override
        public void run() {
            try {
                File progressFile = new File(getExternalCacheDir(), threadID + ".txt");//生成一个专门用来记录下载进度的临时文件
                if (progressFile.exists()) {
                    FileInputStream inputStream = new FileInputStream(progressFile);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    int lastProgress = Integer.parseInt(reader.readLine());
                    startIndex += lastProgress;
                    currentProgress += lastProgress;
                    progressBar.setProgress(currentProgress);
                    handler.sendEmptyMessage(1);
                    inputStream.close();
                }
                URL url = new URL(PATH);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);
                if (connection.getResponseCode() == 206) {
                    InputStream inputStream = connection.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    int total = 0;
                    File file = new File(getExternalCacheDir(), FILENAME);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                    randomAccessFile.seek(startIndex);
                    while ((len = inputStream.read(buffer)) != -1) {
                        randomAccessFile.write(buffer, 0, len);
                        total += len;
                        currentProgress += len;
                        progressBar.setProgress(currentProgress);
                        handler.sendEmptyMessage(1);
                        RandomAccessFile randomAccessFile1 = new RandomAccessFile(progressFile, "rwd");
                        randomAccessFile1.write((total + "").getBytes());
                        randomAccessFile1.close();
                    }
                    randomAccessFile.close();
                    FINISHEDTHREAD++;
                    synchronized (PATH) {
                        if (FINISHEDTHREAD == THREADCOUNT) {
                            for (int i = 0; i < THREADCOUNT; i++) {
                                File file1 = new File(getExternalCacheDir(), i + ".txt");
                                file1.delete();
                            }
                            FINISHEDTHREAD = 0;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
