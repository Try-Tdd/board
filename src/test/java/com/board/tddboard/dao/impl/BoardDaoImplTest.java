package com.board.tddboard.dao.impl;

import com.board.tddboard.dao.BoardDao;
import com.board.tddboard.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardDaoImplTest {

    @Autowired
    private BoardDao boardDao;

    private Board makeBoard() {
        return new Board("제목", "내용", "작성자", "1234");
    }

    @Test
    void 게시글작성() {
        // given
        Board board = makeBoard();

        // when
        Board saveBoard = boardDao.save(board);

        // then
        Board findBoard = boardDao.findById(saveBoard.getId());
        assertThat(findBoard).isNotNull();
    }

    @Test
    void 게시물조회() {
        // given
        Board board = makeBoard();

        Board saveBoard = boardDao.save(board);

        // when
        Board findBoard = boardDao.findById(saveBoard.getId());

        // then
        assertThat(findBoard).isNotNull();
    }

    @Test
    void 게시물삭제() {
        // given
        Board board = makeBoard();

        Board saveBoard = boardDao.save(board);

        // when
        Board findBoard = boardDao.findById(saveBoard.getId());
        boolean passwordCompareResult = findBoard.getPassword().equals(saveBoard.getPassword());

        // then
        if(passwordCompareResult) {
            int resultRowCount = boardDao.removeById(saveBoard.getId());
            assertThat(resultRowCount).isEqualTo(1);
        } else {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }

    @Test
    void 게시물수정() {
        // given
        Board board = makeBoard();

        Board updateBoard = new Board("수정제목", "수정내용", "작성자", "1234");

        Board saveBoard = boardDao.save(board);

        // when
        Board findBoard = boardDao.findById(saveBoard.getId());
        boolean passwordCompareResult = findBoard.getPassword().equals(saveBoard.getPassword());

        // then
        if(passwordCompareResult) {
            int resultRowCount = boardDao.updateById(saveBoard.getId(), updateBoard);
            assertThat(resultRowCount).isEqualTo(1);
        } else {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }
}