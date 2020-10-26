package com.czw.server.controller;

import com.czw.server.response.ShowAnimeZoneResponse;
import com.czw.server.services.AnimeZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 地区的增删改查
 */
@Controller
public class AnimeZoneController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeZoneController.class);

    @Autowired
    private AnimeZoneService animeZoneService;

    @RequestMapping("/showAnimeZone")
    @ResponseBody
    public List<ShowAnimeZoneResponse> showAnimeZone(){
        return animeZoneService.showAnimeZone();
    }
}
