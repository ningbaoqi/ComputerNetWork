package com.shop.ningbaoqi.computernetwork.httpURLConnection;

/**
 * 通常情况下我们都应该将这些通用的网络操作提取到一个公共的类里；并提供一个静态方法，当想要发起网络请求的时候只需要简单的调用一下这个方法即可；并且可以使用Java的回调机制；
 */
public interface HttpCallbackListener {
    void onFinish(String response);//表示当服务器成功响应我们的请求的时候调用，参数就是服务器返回的数据
    void onError(Exception e);//当进行网络操作出现错误时候调用，参数表示记录错误的详细信息
}
