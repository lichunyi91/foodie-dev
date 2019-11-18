package com.imooc.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义响应数据结构
 * 本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 前端接受此类数据（json object）后，可自行根据业务去实现相关功能
 * 200:表示成功
 * 500:表示错误，错误信息在msg字段中
 * 501:bean验证错误，不管多少个错误都以map的形式返回
 * 202:拦截器拦截到用户token出错
 * 555:异常抛出信息
 * 556:用户qq校验异常
 */
@Getter
@Setter
public class IMOOCJSONResult {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    @JsonIgnore
    private String ok; // 不使用


    public static IMOOCJSONResult errorMsg(String msg) {
        return new IMOOCJSONResult(500, msg, null);
    }

    public static IMOOCJSONResult errorMap(Object data) {
        return new IMOOCJSONResult(501, "error", data);
    }

    public static IMOOCJSONResult errorTokenMsg(String msg) {
        return new IMOOCJSONResult(502, msg, null);
    }

    public static IMOOCJSONResult errorException(String msg) {
        return new IMOOCJSONResult(555, msg, null);
    }

    public static IMOOCJSONResult errorUserQQ(String msg) {
        return new IMOOCJSONResult(556, msg, null);
    }

    public static IMOOCJSONResult ok() {
        return new IMOOCJSONResult(null);
    }

    public static IMOOCJSONResult ok(Object data) {
        return new IMOOCJSONResult(data);
    }

    public IMOOCJSONResult(Object data) {
        this(200, "OK", data);
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public IMOOCJSONResult(Integer status, String msg, Object data) {
        this(status, msg, data, null);
    }

    public IMOOCJSONResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }
}
