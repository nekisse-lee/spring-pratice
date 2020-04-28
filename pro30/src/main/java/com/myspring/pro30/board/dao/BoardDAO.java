package com.myspring.pro30.board.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;

public interface BoardDAO {
    public List selectAllArticlesList() throws DataAccessException;
}

