package com.shop.ningbaoqi.computernetwork.httpURLConnection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shop.ningbaoqi.computernetwork.R;

public class SmartImageViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net2);
        String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522659205580&di=9e590dec557c0e77cc0454a10df7c941&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3Df1a6bb82512c11dfde84b72756174ee6%2Faa18972bd40735fa75b232d898510fb30f240814.jpg";
        SmartImageView imageView = (SmartImageView) findViewById(R.id.image);
        imageView.setImageUrl(path);
    }
}