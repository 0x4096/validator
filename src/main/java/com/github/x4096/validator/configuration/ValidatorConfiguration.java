package com.github.x4096.validator.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 22:33
 * @description 配置信息
 * @readme
 */
@Configuration
@ConfigurationProperties(prefix = "x4096.validator")
public class ValidatorConfiguration {

    /**
     * 是否启用参数校验
     */
    private boolean enable = true;

    /**
     * 检验模式: 是否快速失败
     */
    private boolean failFast = true;

    /**
     * 是否使用默认检验返回信息
     */
    private boolean useDefaultCheckMsg = true;

    /**
     * 是否使用默认 400 异常处理
     */
    private boolean useDefaultHttpMessageNotReadable = true;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isFailFast() {
        return failFast;
    }

    public void setFailFast(boolean failFast) {
        this.failFast = failFast;
    }

    public boolean isUseDefaultCheckMsg() {
        return useDefaultCheckMsg;
    }

    public void setUseDefaultCheckMsg(boolean useDefaultCheckMsg) {
        this.useDefaultCheckMsg = useDefaultCheckMsg;
    }

    public boolean isUseDefaultHttpMessageNotReadable() {
        return useDefaultHttpMessageNotReadable;
    }

    public void setUseDefaultHttpMessageNotReadable(boolean useDefaultHttpMessageNotReadable) {
        this.useDefaultHttpMessageNotReadable = useDefaultHttpMessageNotReadable;
    }

    @Override
    public String toString() {
        return "ValidatorConfiguration{" +
                "enable=" + enable +
                ", failFast=" + failFast +
                ", useDefaultCheckMsg=" + useDefaultCheckMsg +
                ", useDefaultHttpMessageNotReadable=" + useDefaultHttpMessageNotReadable +
                '}';
    }

}
