package com.myspring.pro30.board.service;

import com.myspring.pro30.board.vo.ArticleVO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    public List<ArticleVO> listArticles() throws Exception;

    public int addNewArticle(Map articleMap) throws Exception;

    public ArticleVO viewArticle(int articleNO) throws Exception;

    public void modArticle(Map articleMap) throws Exception;

    void removeArticle(int articleNO);
}
