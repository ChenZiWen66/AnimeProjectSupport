package com.czw.server.controller;

import com.czw.server.response.AnimeInfoCountResponse;
import com.czw.server.response.SelectAnimeInfoByAttributeResponse;
import com.czw.server.response.ShowAnimeInfoResponse;
import com.czw.server.services.AnimeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
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
    public List<ShowAnimeInfoResponse> showAnimeInfo() {
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
                                  @RequestParam(value = "anime_uuid") String anime_uuid,
                                  @RequestParam(value = "anime_type") String anime_type,
                                  @RequestParam(value = "anime_describe") String anime_describe,
                                  @RequestParam(value = "alias") String alias,
                                  @RequestParam(value = "anime_zone") String anime_zone,
                                  @RequestParam(value = "anime_year") String anime_year,
                                  @RequestParam(value = "anime_tag") String anime_tag,
                                  @RequestParam(value = "indexes") String indexes,
                                  @RequestParam(value = "update_info") String update_info,
                                  @RequestParam(value = "coverimg_src") String coverimg_src) {
        return animeInfoService.insertAnimeInfo(anime_name, anime_uuid, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag, indexes, update_info, coverimg_src);
    }

    /**
     * 根据属性查询信息数量
     *
     * @param anime_type
     * @param anime_zone
     * @param anime_tag
     * @return
     */
    @ResponseBody
    @PostMapping("/getAnimeInfoCountByAttribute")
    public AnimeInfoCountResponse getAnimeInfoCountByAttribute(@RequestParam(value = "anime_type") String anime_type,
                                                               @RequestParam(value = "anime_zone") String anime_zone,
                                                               @RequestParam(value = "anime_tag") String anime_tag) {
        return animeInfoService.getAnimeInfoCountByAttribute(anime_type, anime_zone, anime_tag);
    }

    /**
     * 根据属性查询信息
     *
     * @param anime_type
     * @param anime_zone
     * @param anime_tag
     * @return
     */
    @ResponseBody
    @PostMapping("/selectAnimeInfoByAttribute")
    public List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByAttribute(@RequestParam(value = "anime_type") String anime_type,
                                                                               @RequestParam(value = "anime_zone") String anime_zone,
                                                                               @RequestParam(value = "anime_tag") String anime_tag,
                                                                               @RequestParam(value = "current_page") int current_page,
                                                                               @RequestParam(value = "page_capacity") int page_capacity) {
        return animeInfoService.selectAnimeInfoByAttribute(anime_type, anime_zone, anime_tag, current_page, page_capacity);
    }

    @ResponseBody
    @PostMapping("/getAnimeInfoCountByName")
    public AnimeInfoCountResponse getAnimeInfoCountByName(@RequestParam(value = "searchContent") String searchContent) {
        return animeInfoService.getAnimeInfoCountByName(searchContent);
    }

    /**
     * 根据搜索内容模糊查询
     *
     * @param searchContent
     * @return
     */
    @ResponseBody
    @PostMapping("/selectAnimeInfoByName")
    public List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByName(@RequestParam(value = "searchContent") String searchContent,
                                                                          @RequestParam(value = "current_page") int current_page,
                                                                          @RequestParam(value = "page_capacity") int page_capacity) {
        return animeInfoService.selectAnimeInfoByName(searchContent, current_page, page_capacity);
    }

    /**
     * 更新动漫信息
     *
     * @param id
     * @param uuid
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
    @PostMapping("/updateAnimeInfo")
    public String updateAnimeInfo(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "anime_name") String anime_name,
                                  @RequestParam(value = "anime_type") String anime_type,
                                  @RequestParam(value = "anime_describe") String anime_describe,
                                  @RequestParam(value = "alias") String alias,
                                  @RequestParam(value = "anime_zone") String anime_zone,
                                  @RequestParam(value = "anime_year") String anime_year,
                                  @RequestParam(value = "anime_tag") String anime_tag,
                                  @RequestParam(value = "indexes") String indexes,
                                  @RequestParam(value = "update_info") String update_info,
                                  @RequestParam(value = "coverimg_src") String coverimg_src) {
        return animeInfoService.updateAnimeInfo(id, uuid, anime_name, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag, indexes, update_info, coverimg_src);
    }

    /**
     * 删除动漫信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/deleteAnimeInfo")
    public String deleteAnimeInfo(@RequestParam(value = "id") int id) {
        return animeInfoService.deleteAnimeInfo(id);
    }
}
