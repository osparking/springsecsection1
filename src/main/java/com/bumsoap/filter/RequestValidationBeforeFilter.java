package com.bumsoap.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class RequestValidationBeforeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
    }
}
