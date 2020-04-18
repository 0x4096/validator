package com.github.x4096.validator.mvc.wrapper.utils;

import com.github.x4096.validator.mvc.wrapper.ResponseWrapper;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 23:25
 * @description
 * @readme
 */
public class ResponseWrapperUtils {

    public static <T> ResponseWrapper<T> failure() {
        return failure("400", "failure");
    }


    public static <T> ResponseWrapper<T> failure(String code, String msg) {
        return failure(code, msg, null);
    }


    public static <T> ResponseWrapper<T> failure(String code, String msg, T data) {
        ResponseWrapper<T> result = new ResponseWrapper<>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
