package com.shop.ningbaoqi.computernetwork.httpURLConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class Utils {

    public static String getTextFromStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        String text = new String(outputStream.toByteArray(), "UTF-8");
        return text;
    }
}
