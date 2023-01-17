package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

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
//        if(session.getAttribute("loginInfo") == null){
//            resp.sendRedirect("/login");
//            return;
//        }

        // session에 loginInfo 라는 이름의 값이 있다면
        if(session.getAttribute("loginInfo") != null){
            chain.doFilter(request, response);
        }

        // session에 loginInfo 값이 없다면 쿠키를 체크한다 (자동로그인 여부)
        Cookie cookie = findCookie(req.getCookies(), "remember-me");

        // session에도 로그인 값이 없고 remember-me 쿠키도 없다면 로그인 페이지로
        if(cookie == null){
            resp.sendRedirect("/login");
            return;
        }

        // remember-me 쿠키가 존재한다면
        log.info("cookie는 존재하는 상황");
        // uuid 값
        String uuid = cookie.getValue();

        try{
            // DB에서 사용자 정보 가져오기
            MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);

            log.info("쿠키의 값으로 조회한 사용자 정보: " + memberDTO);
            // 사용자 정보가 없다면
            if(memberDTO == null){
                // 세션 저장소에 로그인 정보가 없고
                // remember-me 쿠키는 존재하는데
                // 쿠키에 uuid 값은 없다면
                // 어딘가 설계가 잘못된 것이므로 예외를 띄우자
                throw new Exception("Cookie value is not valid");
            }
            // 회원 정보가 있다면 세션에 추가
            session.setAttribute("loginInfo", memberDTO);
            chain.doFilter(request, response);

        }catch(Exception e){
            e.printStackTrace();
            resp.sendRedirect("/login");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String name){
        // 쿠키가 없으면 종료
        if(cookies == null || cookies.length == 0){
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(name))
                .findFirst();

        return result.isPresent() ? result.get() : null;
    }
}
