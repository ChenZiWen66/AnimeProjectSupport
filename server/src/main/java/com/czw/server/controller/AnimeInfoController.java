package com.czw.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimeInfoController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeInfoController.class);

    /**
     * 查询所有动漫信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/showAnimeInfo")
    public String showAnimeInfo(){
        return "开始查询动漫信息";
    }
}
