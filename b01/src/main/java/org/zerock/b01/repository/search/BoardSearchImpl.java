package org.zerock.b01.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.QBoard;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl(){
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable){

        QBoard board = QBoard.board;    // Q도메인 객체

        JPQLQuery<Board> query = from(board);   // select.. from board

        query.where(board.title.contains("1")); // where title like...

        // paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();   // fetch() 로 쿼리 실행

        long count = query.fetchCount();    // fetchCount() 로 count 쿼리 실행

        return null;
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {

        QBoard board = QBoard.board;    // static variable board
        JPQLQuery<Board> query = from(board);

        if ((types != null && types.length > 0) && keyword != null) {
            // 검색조건과 키워드가 존재한다면
            BooleanBuilder booleanBuilder = new BooleanBuilder();   //()

            for (String type : types) {
                switch (type) {
                    case "t":
                        booleanBuilder.or(board.title.contains("keyword"));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains("keyword"));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains("keyword"));
                        break;
                }
            }// end for(){}
            query.where(booleanBuilder);
        }// end if

        // bno > 0
        query.where(board.bno.gt(0L));

        // paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();   // query 실행

        long count = query.fetchCount();    // count query 실행

/*
        return null;    // 아직 결과 리턴 안함
*/
        return new PageImpl<>(list, pageable, count);   // page 생성 규칙을 가진 pageable
    }
}
