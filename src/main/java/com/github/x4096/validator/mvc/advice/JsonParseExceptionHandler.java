package com.github.x4096.validator.mvc.advice;

import com.github.x4096.validator.constants.SystemConstants;
import com.github.x4096.validator.mvc.wrapper.ResponseWrapper;
import com.github.x4096.validator.mvc.wrapper.utils.BodyReaderHttpServletRequestWrapperUtils;
import com.github.x4096.validator.mvc.wrapper.utils.ResponseWrapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.json.JsonParseException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/19 00:28
 * @description 参数解析异常控制处理
 * @readme
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE + 4096)
@ConditionalOnProperty(prefix = "x4096.validator", value = {"enable", "use-default-http-message-not-readable"}, havingValue = "true", matchIfMissing = true)
public class JsonParseExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 参数解析(400)异常处理
     */
    @ExceptionHandler({JsonParseException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseWrapper<String> httpMessageNotReadable(HttpServletRequest request) {
        String requestBody = BodyReaderHttpServletRequestWrapperUtils.getRequestBody(request);
        logger.error("请求参数解析错误, 请求入参: {}", requestBody);
        return ResponseWrapperUtils.failure(HttpStatus.BAD_REQUEST.value() + "", SystemConstants.BAD_REQUEST, requestBody);
    }

}
