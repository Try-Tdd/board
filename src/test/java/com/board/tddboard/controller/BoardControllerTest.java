package com.board.tddboard.controller;

import com.board.tddboard.domain.Board;
import com.board.tddboard.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.assertj.core.api.Assertions.*;

@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Test
    void 게시글생성및조회() throws Exception {
        Board createdBoard = (Board) mockMvc.perform(post("/")
                .param("title", "제목")
                .param("content", "내용")
                .param("writer", "beoum")
                .param("password", "1234"))
                .andReturn()
                .getModelAndView()
                .getModel()
                .get("board");

        assertThat(createdBoard.getId()).isNotNull();
    }
}
