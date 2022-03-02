package com.netbarsm.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @Description     最终返回处理
 * @author liutong
 * @date 2022/3/2 19:32
 */
public class JsonOut<T> {

    private int result = 200;
    private String message = "数据处理完成";

    /**
     * 系统异常
     */
    private String exceptionMsg = "";
    private T data;

    private String dataName = "";

    private HashMap hashMap = new HashMap();


    public static JsonOut instance() {
        return new JsonOut();
    }

    public static JsonOut exception() {
        JsonOut jsonOut = new JsonOut();
        jsonOut.result = 500;
        return jsonOut;
    }

    public JsonOut() {
    }

    public JsonOut addResult(int result) {
        this.result = result;
        return this;
    }

    public JsonOut addMessage(String message) {
        this.message = message;
        return this;
    }

    public JsonOut addException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
        return this;
    }


    public JsonOut addData(T data) {
        this.data = data;
        return this;
    }

    public JsonOut addDataName(String dataName) {
        this.dataName = dataName;
        return this;
    }

    public JsonOut addData(String key, T data) {
        hashMap.put(key, data);
        return this;
    }


    public HashMap build() {
        hashMap.put("result", result);
        hashMap.put("message", message);
        hashMap.put("exceptionMsg", exceptionMsg);
        if (data != null) {
            String name = "".equals(this.dataName) ? data.getClass().getSimpleName() : this.dataName;
            hashMap.put(name, data);
        }
        return hashMap;
    }

    public String json() {
        build();
        return JSON.toJSONString(this);

    }

    public boolean isOk() {
        return result == 200;
    }

}
