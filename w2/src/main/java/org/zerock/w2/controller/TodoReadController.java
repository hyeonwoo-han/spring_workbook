package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
            // 쿼리문 String -> Long 변환
            Long tno = Long.parseLong(request.getParameter("tno")); 

            TodoDTO todoDTO = todoService.get(tno);

            // 데이터 담기
            request.setAttribute("dto", todoDTO);
            
             // 쿠키 찾기
            Cookie viewTodoCookie = findCookie(request.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue(); // 찾은 쿠키의 값

            // 쿠키에 원하는 값이 있는지 확인
            boolean exist = false;
            if(todoListStr != null && todoListStr.indexOf(tno + "-") >= 0){
                exist = true;
            }
            log.info("exist: " + exist);

            // 원하는 값이 없다?
            if(!exist){
                todoListStr += tno + "-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60 * 60 * 24); // 유효기간: 24시간
                viewTodoCookie.setPath("/");
                response.addCookie(viewTodoCookie);
            }

            request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request, response);

        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            throw new ServletException("read error");
        }

    }

    
    // request 쿠키에서 원하는 쿠키 찾기
    private Cookie findCookie(Cookie[] cookies, String cookieName){

        Cookie targetCookie = null;

        // 원하는 이름의 쿠키 찾기
        if(cookies != null && cookies.length > 0){
            for(Cookie ck : cookies){
                if(ck.getName().equals(cookieName)){
                    targetCookie = ck;
                    break;
                }
            }
        }
        
        if(targetCookie == null){
            targetCookie = new Cookie(cookieName, "");  // 이름, 값
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60 * 60 * 24); // 유효기간 : 24시간
        }

        return targetCookie;
    }
}
