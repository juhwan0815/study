package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component // 필터를 스프링 빈으로 등록
public class ZuulLoggingFilter extends ZuulFilter { // Zuul 필터를 구현하기 위해 상속

    @Override
    public String filterType() {
        return "post"; // 필터 타입  pre - 사전 필터 ,post - 사후 필터
    }

    @Override
    public int filterOrder() {
        return 1; // 필터 순서
    }

    @Override
    public boolean shouldFilter() {
        return true; // 필터로 사용
    }

    // 실제 필터의 동작
    @Override
    public Object run() throws ZuulException {
        log.info("****************** printing logs: ");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("****************** " + request.getRequestURI());
        return null;
    }
}
