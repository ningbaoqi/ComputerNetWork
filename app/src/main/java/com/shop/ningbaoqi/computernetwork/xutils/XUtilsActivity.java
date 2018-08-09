package com.shop.ningbaoqi.computernetwork.xutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.ningbaoqi.computernetwork.R;
import com.shop.ningbaoqi.computernetwork.httpURLConnection.HttpUtils;

import java.io.File;

import retrofit2.HttpException;

public class XUtilsActivity extends AppCompatActivity {
    private static String PATH = "http://192.168.188.41:8080/test_video.mp4";
    private ProgressBar progressBar;
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morethread1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.persent);
    }

    public void download(View view) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.download(PATH, getExternalCacheDir() + "testdad.mp4", true/*是否支持断点续传*/, true/*是否支持自动设置文件名*/, new RequestCallBack<File>() {
            @Override
            public void onSuccess(ResponseInfo<File> responseInfo) {//下载成功后调用
                Toast.makeText(XUtilsActivity.this , responseInfo.result.getPath() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(HttpException e, String s) {//下载失败
                Toast.makeText(XUtilsActivity.this , "" + s , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {//当下载时执行该方法
                super.onLoading(total, current, isUploading);
                progressBar.setMax((int) total);
                progressBar.setProgress((int) current);
                textView.setText((current * 100 / total) + "%");
            }
        });
    }
}