package com.spring.ex02;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends MultiActionController {

    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userID = "";
        String passwd = "";
        String viewName = getViewName(request);
        System.out.println("viewName = " + viewName);
        ModelAndView mav = new ModelAndView();
        request.setCharacterEncoding("utf-8");
        userID = request.getParameter("userID");
        passwd = request.getParameter("passwd");

        mav.addObject("userID", userID);
        mav.addObject("passwd", passwd);
//        mav.setViewName("result");
        mav.setViewName(viewName);
        return mav;


    }

    public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String viewName = getViewName(request);
        System.out.println("viewName = " + viewName);

        mav.addObject("id", id);
        mav.addObject("pwd", pwd);
        mav.addObject("name", name);
        mav.addObject("email", email);
//        mav.setViewName("memberInfo");
        mav.setViewName(viewName);
        System.out.println("viewName = " + viewName);
        return mav;
    }

    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = getViewName(request);
        return new ModelAndView(viewName);
    }


    private  String getViewName(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
        if(uri == null || uri.trim().equals("")) {
            uri = request.getRequestURI();
        }

        int begin = 0;
        if(!((contextPath==null)||("".equals(contextPath)))){
            begin = contextPath.length();
        }

        int end;
        if(uri.contains(";")){
            end=uri.indexOf(";");
        }else if(uri.contains("?")){
            end=uri.indexOf("?");
        }else{
            end=uri.length();
        }

        String fileName=uri.substring(begin,end);
        if(fileName.contains(".")){
            fileName=fileName.substring(0,fileName.lastIndexOf("."));
        }
        if(fileName.lastIndexOf("/")!=-1){
            fileName=fileName.substring(fileName.lastIndexOf("/"));
        }

        if (fileName.startsWith("/")) {
            fileName = fileName.substring(1);
        }
        return fileName;
    }
}
