package com.activiti6.demo.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="acorsFilter",urlPatterns="/*")
@Configuration
public class SimpleCORSFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        System.out.println("*********************************过滤器被使用**************************");
//        chain.doFilter(req, res);
        String origin = request.getHeader("origin");// 获取源站
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "1800"); //预检请求返回的结果可以被缓存的时间  单位是秒
        response.setHeader("Access-Control-Allow-Credentials", "true"); //带Cookie的跨域ajax请求
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Content-Type,JWTToken,ticket");
        System.out.println("*********************************过滤器被使用**************************");
        chain.doFilter(req, res);
    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}