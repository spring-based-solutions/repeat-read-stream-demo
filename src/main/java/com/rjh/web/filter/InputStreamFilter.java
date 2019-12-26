package com.rjh.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 可重复读取流的过滤器
 * @author Null
 * @date 2019-12-26
 */
@Slf4j
@WebFilter
public class InputStreamFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        InputStreamRequest request=new InputStreamRequest((HttpServletRequest) servletRequest);
        logRequestBody(request);
        filterChain.doFilter(request,servletResponse);
    }

    /**
     * 打印请求的body
     * @param request
     */
    private void logRequestBody(ServletRequest request){
        try {
            ServletInputStream inputStream=request.getInputStream();
            String charSetStr = request.getCharacterEncoding();
            if (charSetStr == null) {
                charSetStr = "UTF-8";
            }
            Charset charSet = Charset.forName(charSetStr);
            log.info("请求的body为:\n{}",StreamUtils.copyToString(inputStream,charSet));
        } catch (IOException e) {
            log.error("获取流失败");
        }
    }
}
