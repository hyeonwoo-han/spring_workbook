package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try{
            Long tno = Long.parseLong(request.getParameter("tno")); // 쿼리문 String -> Long 변환

            TodoDTO todoDTO = todoService.get(tno);

            // 데이터 담기
            request.setAttribute("dto", todoDTO);
            request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request, response);

        }catch(Exception e){
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }
}
