package com.myspring.pro30.board.service;

import com.myspring.pro30.board.dao.BoardDAO;
import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
        int articleNO = boardDAO.insertNewArticle(articleMap);
        articleMap.put("articleNO", articleNO);
        boardDAO.insertNewImage(articleMap);
        return boardDAO.insertNewArticle(articleMap);
    }

    //단일 파일 보이기

    /*public ArticleVO viewArticle(int articleNO) throws Exception {
        ArticleVO articleVO = boardDAO.selectArticle(articleNO);
        return articleVO;
    }*/

    @Override
    public Map viewArticle(int articleNO) throws Exception {
        Map articleMap = new HashMap();
        ArticleVO articleVO = boardDAO.selectArticle(articleNO);
        List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO);
        articleMap.put("article", articleVO);
        articleMap.put("imageFileList", imageFileList);
        return articleMap;
    }

    @Override
    public void modArticle(Map articleMap) throws Exception {
        boardDAO.updateArticle(articleMap);
    }

    @Override
    public void removeArticle(int articleNO) {
        boardDAO.deleteArticle(articleNO);
    }

}
