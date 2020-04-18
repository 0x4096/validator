package com.github.x4096.validator.mvc.wrapper.utils;

import com.github.x4096.validator.mvc.wrapper.BodyReaderHttpServletRequestWrapper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/19 00:24
 * @description 获取请求体数据 局限于字符串
 * @readme
 */
public class BodyReaderHttpServletRequestWrapperUtils {

    public static String getRequestBody(HttpServletRequest request) {
        return new BodyReaderHttpServletRequestWrapper(request).getBodyString();
    }

}
