package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Login check info.......");

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        HttpSession session = req.getSession();

        // 세션 저장소의 loginInfo 키에 객체가 없다면 /login 화면으로 redirect
        if(session.getAttribute("loginInfo") == null){
            resp.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
