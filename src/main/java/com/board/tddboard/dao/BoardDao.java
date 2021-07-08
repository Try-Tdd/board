package com.board.tddboard.dao;

import com.board.tddboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDao extends JpaRepository<Board, Long> {

    public Board findByIdAndPassword(Long id, String password);

}
