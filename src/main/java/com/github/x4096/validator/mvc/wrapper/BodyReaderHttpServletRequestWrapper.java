package com.github.x4096.validator.mvc.wrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 22:53
 * @description Request 请求参数获取, 用于获取request 请求流中数据
 * @readme
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final byte[] body;

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        String sessionStream = getBodyString(request);
        body = sessionStream.getBytes(StandardCharsets.UTF_8);
    }

    public String getBodyString() {
        return new String(body, StandardCharsets.UTF_8);
    }

    /**
     * 获取请求Body
     */
    private String getBodyString(ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;

        try {
            inputStream = cloneInputStream(request.getInputStream());
            reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("", e);
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error("", e);
                }
            }
        }

        return sb.toString();
    }

    /**
     * 复制输入流
     */
    public InputStream cloneInputStream(ServletInputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;

        try {
            while ((len = inputStream.read(buffer)) > -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            logger.error("", e);
        }

        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }


    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }

}
