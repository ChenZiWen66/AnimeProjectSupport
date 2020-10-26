package com.czw.server.controller;

import com.czw.server.response.ShowAnimeInfoResponse;
import com.czw.server.services.AnimeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimeInfoController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeInfoController.class);

    @Autowired
    private AnimeInfoService animeInfoService;

    /**
     * 查询所有动漫信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/showAnimeInfo")
    public ShowAnimeInfoResponse showAnimeInfo() {
        return animeInfoService.showAnimeInfo();
    }

    @ResponseBody
    @RequestMapping("/insertAnimeInfo")
    public String insertAnimeInfo(){
        return "插入动漫信息";
    }
}
