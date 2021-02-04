package com.czw.server.module.controller;

import com.czw.server.module.response.ShowAnimeTagResponse;
import com.czw.server.module.services.AnimeTagService;
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
    private AnimeTagService animeTagServiceImpl;

    @RequestMapping("/showAnimeTag")
    @ResponseBody
    public List<ShowAnimeTagResponse> showAnimeTag() {
        return animeTagServiceImpl.showAnimeTag();
    }

    @ResponseBody
    @PostMapping("/insertAnimeTag")
    public String insertAnimeTag(@RequestParam(value = "tag_name") String tag_name) {
        return animeTagServiceImpl.insertAnimeTag(tag_name);
    }

    @ResponseBody
    @PostMapping("/updateAnimeTag")
    public String updateAnimeTag(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "tag_name") String tag_name) {
        return animeTagServiceImpl.updateAnimeTag(id, uuid, tag_name);
    }

    @ResponseBody
    @PostMapping("/deleteAnimeTag")
    public String deleteAnimeTag(@RequestParam(value = "id") int id){
        return animeTagServiceImpl.deleteAnimeTag(id);
    }
}
