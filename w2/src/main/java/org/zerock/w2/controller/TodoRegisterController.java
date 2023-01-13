package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", value = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("/todo/register GET .............. ");
        // 세션 공간 가져오기
        HttpSession session = request.getSession();

        if(session.isNew()){ // 기존 JSESSIONID가 없던 새로운 사용자
            log.info("JSESSIONID 쿠키가 새로 만들어진 사용자");
            response.sendRedirect("/login"); // 로그인페이지로 이동
            return;
        }

        // JSESSIONID는 있지만 해당 세션 컨텍스트에 키가 loginInfo인 객체가 없는경우
        if(session.getAttribute("loginInfo") == null){
            log.info("로그인한 정보가 없는 사용자");
            response.sendRedirect("/login");
            return;
        }

        // 정상적인 경우라면 입력화면으로
        request.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        TodoDTO todoDTO = TodoDTO.builder()
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"), DATEFORMATTER))
                .build();

        log.info("/todo/register POST..............");
        log.info(todoDTO);
        try{
            todoService.register(todoDTO);  // register 메소드는 dao 의 insert 호출
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/todo/list");
    }
}
