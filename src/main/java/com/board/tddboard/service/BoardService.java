package com.board.tddboard.service;

import com.board.tddboard.domain.Board;

public interface BoardService {

    public Board save(Board board);
    public Board detail(Long id);
    public void remove(Long id);
    public void update(Long id);

}
