package com.czw.server.module.controller;

import com.czw.server.module.response.ShowAnimeTypeResponse;
import com.czw.server.module.services.impl.AnimeTypeServiceImpl;
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
public class AnimeTypeController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeTypeController.class);

    @Autowired
    private AnimeTypeServiceImpl animeTypeServiceImpl;

    @RequestMapping("/showAnimeType")
    @ResponseBody
    public List<ShowAnimeTypeResponse> showAnimeType() {
        return animeTypeServiceImpl.showAnimeType();
    }

    @ResponseBody
    @PostMapping("/insertAnimeType")
    public String insertAnimeType(@RequestParam(value = "type_name") String type_name) {
        return animeTypeServiceImpl.insertAnimeType(type_name);
    }

    @ResponseBody
    @PostMapping("/updateAnimeType")
    public String updateAnimeType(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "type_name") String type_name) {
        return animeTypeServiceImpl.updateAnimeType(id, uuid, type_name);
    }

    @ResponseBody
    @PostMapping("/deleteAnimeType")
    public String deleteAnimeType(@RequestParam(value = "id") int id){
        return animeTypeServiceImpl.deleteAnimeType(id);
    }
}
