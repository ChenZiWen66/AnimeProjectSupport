package com.czw.server.controller;

import com.czw.server.response.ShowAnimeTypeResponse;
import com.czw.server.services.AnimeTypeService;
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
    private AnimeTypeService animeTypeService;

    @RequestMapping("/showAnimeType")
    @ResponseBody
    public List<ShowAnimeTypeResponse> showAnimeType() {
        return animeTypeService.showAnimeType();
    }

    @ResponseBody
    @PostMapping("/insertAnimeType")
    public String insertAnimeType(@RequestParam(value = "type_name") String type_name) {
        return animeTypeService.insertAnimeType(type_name);
    }

    @ResponseBody
    @PostMapping("/updateAnimeType")
    public String updateAnimeType(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "type_name") String type_name) {
        return animeTypeService.updateAnimeType(id, uuid, type_name);
    }

    @ResponseBody
    @PostMapping("/deleteAnimeType")
    public String deleteAnimeType(@RequestParam(value = "id") int id){
        return animeTypeService.deleteAnimeType(id);
    }
}
