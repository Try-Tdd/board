package com.board.tddboard.dto;

import com.board.tddboard.domain.Board;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class BoardDto {

    @Getter @Setter
    public static class CreateDto {

        @NotEmpty(message = "제목이 존재하지 않습니다.")
        private String title;

        @NotEmpty(message = "내용이 존재하지 않습니다.")
        private String content;

        @NotEmpty(message = "작성자가 존재하지 않습니다.")
        private String writer;

        @NotEmpty(message = "비밀번호가 존재하지 않습니다.")
        private String password;

        public Board toBoard() {
            return new Board(this.title, this.content, this.writer, this.password);
        }
    }

    @Getter @Setter
    public static class UpdateDto {

        @NotEmpty(message = "제목이 존재하지 않습니다.")
        private String title;

        @NotEmpty(message = "내용이 존재하지 않습니다.")
        private String content;

        @NotEmpty(message = "작성자가 존재하지 않습니다.")
        private String writer;

        @NotEmpty(message = "비밀번호가 존재하지 않습니다.")
        private String password;

        public Board toBoard() {
            return new Board(this.title, this.content, this.writer, this.password);
        }
    }

}
