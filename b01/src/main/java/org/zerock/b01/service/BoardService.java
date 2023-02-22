package org.zerock.b01.service;

import org.zerock.b01.dto.BoardDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO);   // insert into (JpaRepository: save)

    BoardDTO readOne(Long bno);         // select (JpaRepository: findById)

    void modify(BoardDTO boardDTO);     // update (JpaRepository: save)

    void remove(Long bno);              // delete (JpaRepository: deleteById)

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
