package com.shop.ningbaoqi.computernetwork.volley;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shop.ningbaoqi.computernetwork.MainActivity;

import org.json.JSONObject;

/**
 * 第一步：获取RequestQueue对象，是一个请求队列对象，可以缓存所有的HTTP请求，按照一定的算法并发的处理这些请求
 * 通过newRequestQueue函数创建并启动一个请求队列requestqueue后，只需要往这个只需要往这个requestqueue不断add request即可
 */
public class VolleyDemo {
    RequestQueue queue = Volley.newRequestQueue(new MainActivity().getContext());//这里就是为了获取上下文

    private void volleyStringRequest() {
        StringRequest stringRequest = new StringRequest(/*Request.Method.GET*/"http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //获取请求
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //错误请求
            }
        });
        queue.add(stringRequest);
    }

    private void volleyJsonRequest() {
        JsonObjectRequest request = new JsonObjectRequest("http://www.sina.com/sports/10101.html", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}