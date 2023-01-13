package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
@Log4j2
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        log.info("log out..............");

        // 세션저장소 내 저장공간 반환
        HttpSession session = request.getSession();

        // 세션저장소의 loginInfo 라는 이름의 값 무효화
        session.removeAttribute("loginInfo");
        session.invalidate();

        // 로그인 기록 삭제했으니 루트로 redirect
        response.sendRedirect("/");
    }
}
