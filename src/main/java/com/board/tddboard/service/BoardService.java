package com.board.tddboard.service;

import com.board.tddboard.domain.Board;

import java.util.List;

public interface BoardService {

    public Board save(Board board);
    public Board getDetail(Long id);
    public List<Board> getList();
    public boolean removeById(Long id, String password);
    public boolean updateById(Long id, Board board);

}
