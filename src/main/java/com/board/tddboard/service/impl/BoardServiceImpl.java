package com.board.tddboard.service.impl;

import com.board.tddboard.dao.BoardDao;
import com.board.tddboard.domain.Board;
import com.board.tddboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardDao boardDao;

    @Autowired
    public void BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public Board save(Board board) {
        boardDao.save(board);
        board.saveCheck();

        return board;
    }

    @Override
    public Board getDetail(Long id) {
        Optional<Board> findBoard = boardDao.findById(id);
        if(findBoard.isEmpty()) {
            throw new IllegalStateException("게시물이 존재하지 않습니다.");
        }

        return findBoard.get();
    }

    @Override
    public List<Board> getList() {
        return boardDao.findAllByOrderByIdDesc();
    }

    @Override
    public boolean removeById(Long id, String password) {
        Board removeBoard = getByIdAndPasswordWithCompare(id, password);

        removeBoard.remove();

        return true;
    }

    @Override
    @Transactional
    public boolean updateById(Long id, Board board) {
        Board updateBoard = getByIdAndPasswordWithCompare(id, board.getPassword());

        updateBoard.changeBoard(board);

        return true;
    }

    private Board getByIdAndPasswordWithCompare(Long id, String password) {
        Board board = boardDao.findByIdAndPassword(id, password);
        if(board == null){
            throw new IllegalStateException("게시물이 존재하지 않습니다. 비밀번호를 확인해주세요.");
        }

        return board;
    }
}
