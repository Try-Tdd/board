package com.board.tddboard.dao.impl;

import com.board.tddboard.dao.BoardDao;
import com.board.tddboard.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BoardDaoImpl implements BoardDao {

    private final EntityManager em;

    @Autowired
    public BoardDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);

        return board;
    }

    @Override
    public Board findById(Long id) {
        return em.find(Board.class, id);
    }

    @Override
    public int removeById(Long id) {
        int deleteResult = em.createQuery("DELETE FROM Board board WHERE board.id=:id")
                .setParameter("id", id)
                .executeUpdate();

        return deleteResult;
    }

    @Override
    public int updateById(Long id, Board board) {
        int updateResult = em.createQuery("UPDATE Board board SET board.title=:title, board.content=:content")
                .setParameter("title", board.getTitle())
                .setParameter("content", board.getContent())
                .executeUpdate();

        return updateResult;
    }

}
