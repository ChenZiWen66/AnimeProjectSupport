package com.czw.server.module.controller;

import com.czw.server.module.response.ShowAnimeZoneResponse;
import com.czw.server.module.services.AnimeZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/animeZone")
@Api(value = "动漫地区接口",tags = "动漫地区接口")
public class AnimeZoneController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeZoneController.class);

    @Autowired
    private AnimeZoneService animeZoneService;

    @GetMapping("/showAnimeZone")
    @ApiOperation(value = "获取地区信息", notes = "获取所有动漫地区信息")
    @ResponseBody
    public List<ShowAnimeZoneResponse> showAnimeZone() {
        return animeZoneService.showAnimeZone();
    }

    @ResponseBody
    @PostMapping("/insertAnimeZone")
    @ApiOperation(value = "添加动漫地区", notes = "添加动漫地区")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "zone_name", value = "地区名", paramType = "String", dataType = "String", required = true)
    })
    public String insertAnimeZone(@RequestParam(value = "zone_name") String zone_name) {
        return animeZoneService.insertAnimeZone(zone_name);
    }

    @ResponseBody
    @PostMapping("/updateAnimeZone")
    @ApiOperation(value = "更新动漫地区", notes = "更新动漫地区")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地区id", paramType = "Integer", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "uuid", value = "地区uuid", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "zone_name", value = "地区名", paramType = "String", dataType = "String", required = true)
    })
    public String updateAnimeZone(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "zone_name") String zone_name) {
        return animeZoneService.updateAnimeZone(id, uuid, zone_name);
    }

    @ResponseBody
    @PostMapping("/deleteAnimeZone")
    @ApiOperation(value = "删除动漫地区", notes = "删除动漫地区")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地区id", paramType = "Integer", dataType = "Integer", required = true)
    })
    public String deleteAnimeZone(@RequestParam(value = "id") int id){
        return animeZoneService.deleteAnimeZone(id);
    }
}
