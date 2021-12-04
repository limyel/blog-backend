package com.limyel.blog.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class OkHttpUtil {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");

    @Autowired
    private OkHttpClient okHttpClient;

    /**
     *
     * @param url
     * @return
     */
    public String doGet(String url) {
        return doGet(url, null, null);
    }

    public String doGet(String url, Map<String, String> params) {
        return doGet(url, params, null);
    }

    public String doGet(String url, List<String> headers) {
        return doGet(url, null, headers);
    }

    /**
     *
     * @param url       url 地址
     * @param params    请求参数
     * @param headers   请求头
     * @return
     */
    public String doGet(String url, Map<String, String> params, List<String> headers) {
        StringBuilder stringBuilder = new StringBuilder(url);
        if (params != null && params.keySet().size() > 0) {
            boolean firstFlag = true;
            for (String key: params.keySet()) {
                if (firstFlag) {
                    stringBuilder.append("?");
                    firstFlag = false;
                } else {
                    stringBuilder.append("&");
                }
                stringBuilder.append(key).append("=").append(params.get(key));
            }
        }

        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            if (headers.size() % 2 == 0) {
                for (int i = 0; i < headers.size(); i = i + 2) {
                    builder.addHeader(headers.get(i), headers.get(i+1));
                }
            } else {
                log.warn("headers's length[{}] is error.", headers.size());
            }
        }

        Request request = builder.url(stringBuilder.toString()).build();
        log.info("do get request and url[{}]", stringBuilder.toString());
        return execute(request);
    }

    /**
     *
     * @param url
     * @param params
     * @return
     */
    public String doPost(String url, Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder();

        if (params != null && params.keySet().size() > 0) {
            for (String key: params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        log.info("do post request and url[{}]", url);

        return execute(request);
    }

    /**
     *
     * @param url
     * @param data
     * @return
     */
    public String doPostJson(String url, String data) {
        log.info("do post request and url[{}]", url);
        return executePost(url, data, JSON);
    }

    public String executePost(String url, String data, MediaType mediaType) {
        RequestBody requestBody = RequestBody.create(data, mediaType);
        Request request = new Request.Builder().url(url).post(requestBody).build();

        return execute(request);
    }

    public String execute(Request request) {
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }
}
