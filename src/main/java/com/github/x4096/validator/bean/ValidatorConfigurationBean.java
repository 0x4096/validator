package com.github.x4096.validator.bean;

import com.github.x4096.validator.configuration.ValidatorConfiguration;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/25 18:00
 * @description 校验模式选择
 * @readme
 */
@Configuration
@ConditionalOnProperty(prefix = "x4096.validator", value = {"enable"}, havingValue = "true")
public class ValidatorConfigurationBean {

    @Resource
    private ValidatorConfiguration validatorConfiguration;

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", validatorConfiguration.isFailFast() + "")
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

}
