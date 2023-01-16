package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        log.info("Login get...........");

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        log.info("login post...........");

        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");
        String auto = request.getParameter("auto"); // 자동 로그인
        boolean rememberMe = auto != null && auto.equals("on"); // true, false

       try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);

            // rememberMe가 true라면
            if(rememberMe){
               // 임의의 번호 생성
               String uuid = UUID.randomUUID().toString();

               // uuid update
               MemberService.INSTANCE.updateUuid(mid, uuid);
               memberDTO.setUuid(uuid);

               // uuid를 담은 쿠키 브라우저에 전송
                Cookie rememberCookie = new Cookie("remember-me", uuid);
                rememberCookie.setMaxAge(60 * 60 * 24 * 7); // 유효기간 7일
                rememberCookie.setPath("/");

                // 사용자 정의 쿠키 전송
                response.addCookie(rememberCookie);
            }

            // 세션저장소 내 저장공간 반환
            HttpSession session = request.getSession();
            // 해당 저장공간(세션, 세션컨텍스트)에 loginInfo 라는 이름으로 memberDTO 저장
            session.setAttribute("loginInfo", memberDTO);
            response.sendRedirect("/todo/list");

       }catch(Exception e){
            response.sendRedirect("/login?result=error");
       }
    }
}
