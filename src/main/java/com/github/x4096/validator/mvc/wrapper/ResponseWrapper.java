package com.github.x4096.validator.mvc.wrapper;

import java.io.Serializable;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 23:09
 * @description 响应信息封装
 * @readme
 */
public class ResponseWrapper<T> implements Serializable {

    private boolean success;

    private String code;

    private String msg;

    private T data;

    public ResponseWrapper() {
        this.success = true;
        this.code = "200";
        this.msg = "success";
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
