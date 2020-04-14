package com.myspring.pro28.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller()
public class LocaleController {


    @RequestMapping(value = "/test/locale.do", method = {RequestMethod.GET})
    public String locale(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("loclaeController입니다.");
        return "locale";
    }
}
