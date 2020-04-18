package com.github.x4096.validator.mvc.advice;

import com.github.x4096.validator.mvc.wrapper.ResponseWrapper;
import com.github.x4096.validator.mvc.wrapper.utils.BodyReaderHttpServletRequestWrapperUtils;
import com.github.x4096.validator.mvc.wrapper.utils.ResponseWrapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 22:40
 * @description 参数校验异常控制处理
 * @readme
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE + 4096)
@ConditionalOnProperty(prefix = "x4096.validator", value = {"enable", "use-default-check-msg"}, havingValue = "true", matchIfMissing = true)
public class MethodArgumentNotValidExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 参数校验异常处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseWrapper<Boolean> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        logger.info("参数校验错误, 请求入参: {}", BodyReaderHttpServletRequestWrapperUtils.getRequestBody(request));

        StringBuilder errorMessage = new StringBuilder("Invalid Param: ");

        BindingResult bindingResult = e.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage.append(fieldError.getField())
                    .append("=[")
                    .append(fieldError.getRejectedValue())
                    .append("]")
                    .append(fieldError.getDefaultMessage());
        }

        String returnMsg = errorMessage.toString();

        logger.error("参数校验错误: {}", returnMsg);

        return ResponseWrapperUtils.failure(HttpStatus.NOT_ACCEPTABLE.value() + "", returnMsg);
    }

}
