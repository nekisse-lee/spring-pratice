package com.myspring.pro29.ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ResController {

    @RequestMapping("/res1")
    @ResponseBody
    public Map<String, Object> res1() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "hong");
        map.put("name", "홍길동");
        return map;
    }

    @RequestMapping("res2")
    public ModelAndView res2() {
        return new ModelAndView("home");
    }
}
