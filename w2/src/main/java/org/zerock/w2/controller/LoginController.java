package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

        String str = mid + mpw;

        HttpSession session = request.getSession();

        session.setAttribute("loginInfo", str); // 세션 저장소의 사용자 공간에 loginInfo 이름으로 문자열 보관

        response.sendRedirect("/todo/list");
    }
}
