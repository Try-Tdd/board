package com.board.tddboard.dao;

import com.board.tddboard.domain.Board;

public interface BoardDao {

    public Board save(Board board);
    public Board findById(Long id);
    public int removeById(Long id);
    public int updateById(Long id, Board board);

}
