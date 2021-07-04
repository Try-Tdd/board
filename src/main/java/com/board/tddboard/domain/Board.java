package com.board.tddboard.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
