package com.myspring.pro30.board.controller;

import com.myspring.pro30.board.service.BoardService;
import com.myspring.pro30.board.vo.ArticleVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
    private static final String ARTICLE_IMAGE_REPO =
            "/Users/nekisse/Documents/intellij_workspace/spring-pratice/pro30/article_image";


    @Autowired
    BoardService boardService;

    @Autowired
    ArticleVO articleVO;

    @Override
    @RequestMapping(value = "/board/listArticles.do", method = RequestMethod.GET)
    public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = (String) request.getAttribute("viewName");
        System.out.println("viewName = " + viewName);
        List articlesList = boardService.listArticles();
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("articlesList", articlesList);
        return mav;
    }
}
