package com.android.mysdk.okhttp.request;


import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by Administrator on 2018/4/1.
 * @function 接收请求参数 为我们生成Request对象
 */

public class CommonRequest {

    /**
     *
     * @param url
     * @param params
     * @return 返回 创建好的Request对象
     */
    public static Request createPostRequest(String url,RequestParams params){
        FormBody.Builder mFromBodyBuild=new FormBody.Builder();
        if (params!=null){

        }
        return null;
    }

}
