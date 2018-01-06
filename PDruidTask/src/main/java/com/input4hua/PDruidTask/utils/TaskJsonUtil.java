package com.input4hua.PDruidTask.utils;

import com.google.common.base.Charsets;
import com.input4hua.PDruidTask.model.SourceModel;
import com.input4hua.PDruidTask.model.TargetModel;
import org.apache.http.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Date;

/**
 * Created by jiahua.hu on 2018/1/6.
 */
public class TaskJsonUtil {

    private final static String taskUrl = "http://localhost:8090/druid/indexer/v1/task";

    private static TargetModel parseFormSourceToTarget(SourceModel source){
        TargetModel target = new TargetModel();
        target.setId("10");
        target.setUsername("jiahua.hu");
        target.setPassword("jiahua.huPwss");
        target.setBirthday(new Date());
        return target;
    }

    public static String postTask(SourceModel source){
        TargetModel target = parseFormSourceToTarget(source);
        String result = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpPost httpPost = buildHttpPost(taskUrl,target);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                HttpEntity entity = httpResponse.getEntity();
                String content = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
                result = content;
            }else{
                result = statusCode+"";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static HttpPost buildHttpPost(String url, TargetModel target) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-type","application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
        if(target != null){
            httpPost.setEntity(new StringEntity(JsonUtil.parseObj2JsonString(target), Charsets.UTF_8));
        }
        return httpPost;
    }

    public static void main(String[] args) {
        postTask(new SourceModel());
    }


}
