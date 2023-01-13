package org.zerock.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2 // Lombok 라이브러리의 Log4j2 어노테이션
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService(){
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception{
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class); // DTO 객체를 VO로 복사
        //System.out.println("todoVO: " + todoVO);
        log.info(todoVO);
        dao.insert(todoVO); // int를 반환하므로 이를 이용해서 예외처리도 가능
    }

    public List<TodoDTO> listAll() throws Exception{
        // dao로 모든 레코드 추출
        List<TodoVO> voList = dao.selectAll();
        log.info("voList............");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream() // 몰라
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());  // 몰라
        return dtoList;
    }

    public TodoDTO get(Long tno) throws Exception{
        log.info("tno: " + tno);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    public void remove(Long tno) throws Exception{
        log.info("tno: " + tno);
        dao.deleteOne(tno); // 삭제
    }

    public void modify(TodoDTO todoDTO) throws Exception{
        log.info("todoDTO: " + todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        dao.updateOne(todoVO);
    }
}
