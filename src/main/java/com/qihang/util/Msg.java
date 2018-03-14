package com.qihang.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回的类
 *
 */
public class Msg {
    //状态码   100-失败/没有内容    200-成功/有内容
    private int code;
    //提示信息
    private String msg;

    //用户要返回给浏览器的数据
    private Map<String, Object> jsondata = new HashMap<String, Object>();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理成功！");
        return result;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理失败！");
        return result;
    }

    public Msg add(String key, Object value) {
        this.getjsondata().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getjsondata() {
        return jsondata;
    }

    public void setjsondata(Map<String, Object> jsondata) {
        this.jsondata = jsondata;
    }


}
