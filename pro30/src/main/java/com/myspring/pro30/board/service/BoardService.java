package com.myspring.pro30.board.service;

import com.myspring.pro30.board.vo.ArticleVO;

import java.util.List;

public interface BoardService {

    public List<ArticleVO> listArticles() throws Exception;

}
