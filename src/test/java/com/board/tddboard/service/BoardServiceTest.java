package com.board.tddboard.service;

import com.board.tddboard.domain.Board;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    private Board newBoard;

    @BeforeEach
    private void makeBoard() {
        this.newBoard = new Board("제목", "내용", "작성자", "1234");
    }

    @Test
    void 게시물작성() {
        // given
        Board board = newBoard;

        // when
        boardService.save(board);

        // then
        assertThat(board.getId()).isNotNull();
    }

    @Test
    void 게시물조회() {
        // given
        Board board = newBoard;

        boardService.save(board);

        // when
        Board findBoard = boardService.getDetail(board.getId());

        // then
        assertThat(findBoard).isNotNull();
    }

    @Test
    void 게시물삭제() {
        // given
        Board board = newBoard;

        boardService.save(board);

        // when
        boolean result = boardService.removeById(board.getId(), board.getPassword());

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 게시물수정() {
        // given
        Board board = newBoard;
        Board updateBoard = new Board("수정된제목", "내용", "작성자", "1234");

        boardService.save(board);

        // when
        boolean result = boardService.updateById(board.getId(), updateBoard);

        // then
        assertThat(result).isTrue();
        assertThat(board.getTitle()).isEqualTo(updateBoard.getTitle());
    }

    @Test
    void 게시물전체조회() {
        // given
        Board board1 = newBoard;
        Board board2 = new Board("수정된제목", "내용", "작성자", "1234");

        boardService.save(board1);
        boardService.save(board2);

        // when
        List<Board> list = boardService.getList();

        // then
        assertThat(list.size()).isEqualTo(2);
    }
}
