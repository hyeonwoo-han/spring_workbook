package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

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

       try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
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
