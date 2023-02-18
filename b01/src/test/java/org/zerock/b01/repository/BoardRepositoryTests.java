package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.domain.Board;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){
        // board 에 해당하는 레코드를 하나 만든것과 마찬가지
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("title......" + i)
                    .content("content......" + i)
                    .writer("user" + (i % 10))
                    .build();

            // 만들어진 레코드를 db 테이블에 insert 혹은 update
            Board result = boardRepository.save(board);
            log.info("BNO: " + result.getBno());
        });
    }
}
