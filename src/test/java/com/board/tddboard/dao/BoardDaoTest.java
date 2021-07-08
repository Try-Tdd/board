package com.board.tddboard.dao;

import com.board.tddboard.dao.BoardDao;
import com.board.tddboard.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class BoardDaoTest {

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
        assertThat(saveBoard.getId()).isNotNull();
    }

    @Test
    void 게시물조회() {
        // given
        Board board = makeBoard();

        Board saveBoard = boardDao.save(board);

        // when
        Board findBoard = boardDao.findById(saveBoard.getId()).get();

        // then
        assertThat(findBoard).isNotNull();
    }

    @Test
    void 게시물수정() {
        // given
        String changeTitle = "변경된 제목";
        Board board = makeBoard();

        Board saveBoard = boardDao.save(board);

        // when
        saveBoard.changeTitle(changeTitle);
        Board updateBoard = boardDao.save(saveBoard);

        // then
        assertThat(updateBoard.getTitle()).isEqualTo(saveBoard.getTitle());
    }

    @Test
    void 게시물리스트조회() {
        // given
        Board board1 = makeBoard();
        Board board2 = makeBoard();
        List<Board> boardList = new ArrayList<>();

        boardList.add(board1);
        boardList.add(board2);

        boardDao.saveAll(boardList);

        // when
        List<Board> findBoardList = boardDao.findAll();

        // then
        assertThat(findBoardList.size()).isEqualTo(2);
    }
}