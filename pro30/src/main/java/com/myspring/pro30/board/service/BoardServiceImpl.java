package com.myspring.pro30.board.service;

import com.myspring.pro30.board.dao.BoardDAO;
import com.myspring.pro30.board.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDAO boardDAO;

    @Override
    public List<ArticleVO> listArticles() throws Exception {
        List<ArticleVO> articlesList = boardDAO.selectAllArticlesList();
        return articlesList;
    }

    @Override
    public int addNewArticle(Map articleMap) throws Exception {
        return boardDAO.insertNewArticle(articleMap);
    }

    //단일 파일 보이기

    public ArticleVO viewArticle(int articleNO) throws Exception {
        ArticleVO articleVO = boardDAO.selectArticle(articleNO);
        return articleVO;
    }

}
