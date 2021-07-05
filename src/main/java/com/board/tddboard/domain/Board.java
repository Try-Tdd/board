package com.board.tddboard.domain;

import lombok.Getter;

import java.time.LocalDateTime;

public class Board {

    @Getter
    private Long id;

    @Getter
    private LocalDateTime createdAt;

    @Getter
    private LocalDateTime updatedAt;

    @Getter
    private LocalDateTime deletedAt;

    @Getter
    private String title;

    @Getter
    private String content;

    @Getter
    private String writer;

    @Getter
    private String password;

}
