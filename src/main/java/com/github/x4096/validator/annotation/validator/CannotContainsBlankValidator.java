package com.github.x4096.validator.annotation.validator;

import com.github.x4096.validator.annotation.CannotContainsBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 22:31
 * @description 校验逻辑
 * @readme
 */
public class CannotContainsBlankValidator implements ConstraintValidator<CannotContainsBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value != null && value.contains(" ")) {
            /* 获取默认提示信息 */
            String defaultConstraintMessageTemplate = constraintValidatorContext.getDefaultConstraintMessageTemplate();
            /* 禁用默认提示信息 */
            constraintValidatorContext.disableDefaultConstraintViolation();
            /* 设置提示语 */
            constraintValidatorContext.
                    buildConstraintViolationWithTemplate(defaultConstraintMessageTemplate)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

}
