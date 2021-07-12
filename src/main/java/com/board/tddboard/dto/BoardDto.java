package com.board.tddboard.dto;

import com.board.tddboard.domain.Board;
import lombok.Getter;
import lombok.Setter;

public class BoardDto {

    @Getter @Setter
    public static class CreateDto {
        private String title;
        private String content;
        private String writer;
        private String password;

        public Board toBoard() {
            return new Board(this.title, this.content, this.writer, this.password);
        }
    }

}
