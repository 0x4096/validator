package com.github.x4096.validator.mvc.filter;

import com.github.x4096.validator.mvc.wrapper.BodyReaderHttpServletRequestWrapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 22:51
 * @description 通道过滤器, 用于在获取流后再写入
 * @readme
 */
@Component
@ConditionalOnProperty(prefix = "x4096.validator", value = {"enable"}, havingValue = "true", matchIfMissing = false)
public class ChannelFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /* do nothing */
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /* 将流继续写出去 */
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {
        /* do nothing */
    }

}
