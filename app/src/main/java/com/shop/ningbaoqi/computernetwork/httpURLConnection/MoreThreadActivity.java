package com.shop.ningbaoqi.computernetwork.httpURLConnection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoreThreadActivity extends AppCompatActivity {
    private static String PATH = "http://192.168.188.41:8080/sb.mp4";
    private static int length;
    private static int THREADCOUNT = 3;
    private static int SINGLESIZE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morethread);
    }

    public void download(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(PATH);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    if (connection.getResponseCode() == 200) {
                        length = connection.getContentLength();
                        File file = new File(getExternalCacheDir() + "/ningbaoqi.mp4");
                        Log.d("nbq", getExternalCacheDir() + "");
                        /**
                         * 随机存储文件，使用rwd模式时，在下载的时候将数据同步写到底层存储设备，提供了数据的可靠性
                         * */
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                        randomAccessFile.setLength(length);//设置临时文件大小
                        randomAccessFile.close();
                        SINGLESIZE = length / THREADCOUNT;
                        for (int i = 0; i < THREADCOUNT; i++) {
                            int startIndex = i * SINGLESIZE;
                            int endIndex = (i + 1) * SINGLESIZE - 1;
                            if (i == THREADCOUNT - 1) {
                                endIndex = length - 1;
                            }
                            new DownloadThread(startIndex, endIndex, i).start();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    class DownloadThread extends Thread {
        int startIndex;
        int endIndex;
        int threadID;

        public DownloadThread(int startIndex, int endIndex, int threadID) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.threadID = threadID;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(PATH);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Range" , "bytes=" + startIndex + "-" + endIndex);//设置本次http请求所请求的数据区间
                if (connection.getResponseCode() == 206) {//请求部分数据的响应码是206
                    InputStream inputStream = connection.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    File file = new File(getExternalCacheDir() + "/ningbaoqi.mp4");
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                    randomAccessFile.seek(startIndex);//将文件的写入位置移动到指定位置
                    while ((len = inputStream.read(buffer)) != -1) {
                        randomAccessFile.write(buffer , 0 , len);
                    }
                    randomAccessFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
