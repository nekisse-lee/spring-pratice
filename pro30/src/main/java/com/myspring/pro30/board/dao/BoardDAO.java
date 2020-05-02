package com.myspring.pro30.board.dao;

import com.myspring.pro30.board.vo.ArticleVO;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
    public List selectAllArticlesList() throws DataAccessException;

    public int insertNewArticle(Map articleMap) throws DataAccessException;

    public ArticleVO selectArticle(int articleNO) throws DataAccessException;

    void updateArticle(Map articleMap) throws DataAccessException;
}

