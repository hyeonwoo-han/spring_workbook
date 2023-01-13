package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})    // 모든 경로에서 이 필터 사용
@Log4j2
public class UTF8Filter implements Filter {

    // POST 방식으로 받은 문자의 한글 처리

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("UTF8 filter.....");

        HttpServletRequest req = (HttpServletRequest) request;  // 다운캐스팅
        req.setCharacterEncoding("UTF-8");  // request로 받은 값의 인코딩 방식 변경

        chain.doFilter(request, response);
    }
}
