package com.board.tddboard.domain;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
public class Board {

    public Board() {}

    public Board(String title, String content, String writer, String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String password;

    public void remove() {
        this.deletedAt = LocalDateTime.now();
    }

    public void changeBoard(Board board) {
        if(board.getTitle() != null) {
            this.title = board.getTitle();
        }
        if(board.getContent() != null) {
            this.content = board.getContent();
        }
    }

    public void saveCheck() {
        if(this.id == null) {
            throw new IllegalStateException("게시물이 저장되지 않았습니다.");
        }
    }

    public boolean isRemoved() {
        if(this.deletedAt == null) {
            return false;
        }

        return true;
    }
}
