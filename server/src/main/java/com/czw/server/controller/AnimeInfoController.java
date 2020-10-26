package com.czw.server.controller;

import com.czw.server.response.ShowAnimeInfoResponse;
import com.czw.server.services.AnimeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 插入动漫信息
     *
     * @param anime_name
     * @param anime_type
     * @param anime_describe
     * @param alias
     * @param anime_zone
     * @param anime_year
     * @param anime_tag
     * @param indexes
     * @param update_info
     * @param coverimg_src
     * @return
     */
    @ResponseBody
    @PostMapping("/insertAnimeInfo")
    public String insertAnimeInfo(@RequestParam(value = "anime_name") String anime_name,
                                  @RequestParam(value = "anime_type") String anime_type,
                                  @RequestParam(value = "anime_describe") String anime_describe,
                                  @RequestParam(value = "alias") String alias,
                                  @RequestParam(value = "anime_zone") String anime_zone,
                                  @RequestParam(value = "anime_year") String anime_year,
                                  @RequestParam(value = "anime_tag") String anime_tag,
                                  @RequestParam(value = "indexes") String indexes,
                                  @RequestParam(value = "update_info") String update_info,
                                  @RequestParam(value = "coverimg_src") String coverimg_src) {
        return animeInfoService.insertAnimeInfo(anime_name, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag, indexes, update_info, coverimg_src);
    }

    @ResponseBody
    @PostMapping("/selectAnimeInfoByAttribute")
    public String selectAnimeInfoByAttribute(@RequestParam(value = "anime_type") String anime_type,
                                             @RequestParam(value = "anime_zone") String anime_zone,
                                             @RequestParam(value = "anime_tag") String anime_tag) {
        return "查询成功";
    }
}
