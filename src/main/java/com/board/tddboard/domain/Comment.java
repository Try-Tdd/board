package com.board.tddboard.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Comment {

    @Getter
    private Long id;

    @Getter
    private LocalDateTime createdAt;

    @Getter
    private LocalDateTime updatedAt;

    @Getter
    private LocalDateTime deletedAt;

    @Getter @Setter
    private String content;

    @Getter @Setter
    private String writer;

    @Getter @Setter
    private String password;

}
