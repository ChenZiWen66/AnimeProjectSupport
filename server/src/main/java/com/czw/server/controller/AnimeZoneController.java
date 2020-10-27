package com.czw.server.controller;

import com.czw.server.response.ShowAnimeZoneResponse;
import com.czw.server.services.AnimeZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地区的增删改查
 */
@Controller
@CrossOrigin
public class AnimeZoneController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeZoneController.class);

    @Autowired
    private AnimeZoneService animeZoneService;

    @RequestMapping("/showAnimeZone")
    @ResponseBody
    public List<ShowAnimeZoneResponse> showAnimeZone() {
        return animeZoneService.showAnimeZone();
    }

    @ResponseBody
    @PostMapping("/insertAnimeZone")
    public String insertAnimeZone(@RequestParam(value = "zone_name") String zone_name) {
        return animeZoneService.insertAnimeZone(zone_name);
    }

    @ResponseBody
    @PostMapping("/updateAnimeZone")
    public String updateAnimeZone(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "zone_name") String zone_name) {
        return animeZoneService.updateAnimeZone(id, uuid, zone_name);
    }

    @ResponseBody
    @PostMapping("/deleteAnimeZone")
    public String deleteAnimeZone(@RequestParam(value = "id") int id){
        return animeZoneService.deleteAnimeZone(id);
    }
}
