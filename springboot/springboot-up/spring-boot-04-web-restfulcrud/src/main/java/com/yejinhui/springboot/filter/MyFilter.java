package com.yejinhui.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/27 10:07
 */
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process ...");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }

}
