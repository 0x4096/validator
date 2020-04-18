package com.github.x4096.validator.annotation;

import com.github.x4096.validator.annotation.validator.CannotContainsBlankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 22:30
 * @description 不能包含空格, 前提是字符串不为 null
 * @readme
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CannotContainsBlankValidator.class)
@Documented
public @interface CannotContainsBlank {

    /* 默认错误消息 */
    String message() default "不能包含空格";

    /* 分组 */
    Class<?>[] groups() default {};

    /* 分组 */
    Class<? extends Payload>[] payload() default {};

}
