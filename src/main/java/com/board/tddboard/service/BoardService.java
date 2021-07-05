package com.board.tddboard.service;

import com.board.tddboard.domain.Board;

public interface BoardService {

    public Board save(Board board);
    public Board getDetail(Long id);
    public void removeById(Long id);
    public void updateById(Long id);

}
