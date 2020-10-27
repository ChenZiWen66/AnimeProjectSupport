package com.czw.server.controller;

import com.czw.server.response.ShowAnimeTagResponse;
import com.czw.server.services.AnimeTagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类型的增删改查
 */
@Controller
@CrossOrigin
public class AnimeTagController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeTagController.class);

    @Autowired
    private AnimeTagService animeTagService;

    @RequestMapping("/showAnimeTag")
    @ResponseBody
    public List<ShowAnimeTagResponse> showAnimeTag() {
        return animeTagService.showAnimeTag();
    }

    @ResponseBody
    @PostMapping("/insertAnimeTag")
    public String insertAnimeTag(@RequestParam(value = "tag_name") String tag_name) {
        return animeTagService.insertAnimeTag(tag_name);
    }

    @ResponseBody
    @PostMapping("/updateAnimeTag")
    public String updateAnimeTag(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "tag_name") String tag_name) {
        return animeTagService.updateAnimeTag(id, uuid, tag_name);
    }

    @ResponseBody
    @PostMapping("/deleteAnimeTag")
    public String deleteAnimeTag(@RequestParam(value = "id") int id){
        return animeTagService.deleteAnimeTag(id);
    }
}
