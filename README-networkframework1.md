### HttpURLConnection
#### [使用HttpURLConnection的GET请求获取网络图片](https://github.com/ningbaoqi/ComputerNetWork/commit/85a1c924976b28f2bef8de1ae39f06d5a8f003ed)

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/b1.gif)

#### [使用HttpURLConnection将网络上的图片缓存到本地]()
```
if (connection.getResponseCode() == 200) {//如果连接的返回状态码是 200 则说明连接成功，并且服务器会以流的方式传递数据
    InputStream inputStream = connection.getInputStream();//获取服务器响应头中的流，流中的数据就是客户端请求的数据
    bitmap = BitmapFactory.decodeStream(inputStream);//将流中的内容解析成Bitmap对象
    //bitmap = BitmapFactory.decodeStream(inputStream);//将流中的内容解析成Bitmap对象
    File file = new File(getCacheDir(), "you.jpg");
    FileOutputStream outputStream = new FileOutputStream(file);
    byte[] buffer = new byte[1024];
    int len = 0;
    while ((len = inputStream.read(buffer)) != -1) {//由于在输入流中的数据已经被读取出来了，所以再次读取将会什么都没有了，所以需要使用本地缓存的图片来作为位图的资源
        outputStream.write(buffer, 0, len);
    }
    handler.sendEmptyMessage(0x123);
    inputStream.close();
}
```

#### [使用HttpURLConnection获取网络文本文件](https://github.com/ningbaoqi/ComputerNetWork/commit/b6ae7214f1d177106dfb79f46dd183b05d7078dc)
#### [使用HttpURLConnection的GET请求向服务器提交用户名密码并解决乱码问题](https://github.com/ningbaoqi/ComputerNetWork/commit/51cefc8c0f134e8cec3d2bf0672121f62a1b3a51)
#### [使用HttpURLConnection的POST请求提交用户名密码并提取数据](https://github.com/ningbaoqi/ComputerNetWork/commit/563f25c3cdb6842e05e26cc2d8e62c7a5480e9c8)
#### [使用HttpURLConnection多线程下载视频](https://github.com/ningbaoqi/ComputerNetWork/commit/a1a00d6ea1a0b4e86726d6905d0626da868d82bb)
