package com.czw.server.module.controller;

import com.czw.server.module.response.ShowAnimeTypeResponse;
import com.czw.server.module.services.AnimeTypeService;
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
 * 类型的增删改查
 */
@Controller
@CrossOrigin
@RequestMapping("/animeType")
@Api(value = "动漫类型接口",tags = "动漫类型接口")
public class AnimeTypeController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeTypeController.class);

    @Autowired
    private AnimeTypeService animeTypeService;

    @GetMapping("/showAnimeType")
    @ApiOperation(value = "获取动漫类型", notes = "获取动漫类型")
    @ResponseBody
    public List<ShowAnimeTypeResponse> showAnimeType() {
        return animeTypeService.showAnimeType();
    }

    @ResponseBody
    @PostMapping("/insertAnimeType")
    @ApiOperation(value = "添加动漫类型", notes = "添加动漫类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type_name", value = "类型名称", paramType = "String", dataType = "String", required = true)
    })
    public String insertAnimeType(@RequestParam(value = "type_name") String type_name) {
        return animeTypeService.insertAnimeType(type_name);
    }

    @ResponseBody
    @PostMapping("/updateAnimeType")
    @ApiOperation(value = "更新动漫类型", notes = "更新动漫类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类型id", paramType = "Integer", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "uuid", value = "类型uuid", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "type_name", value = "类型名", paramType = "String", dataType = "String", required = true),
    })
    public String updateAnimeType(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "type_name") String type_name) {
        return animeTypeService.updateAnimeType(id, uuid, type_name);
    }

    @ResponseBody
    @ApiOperation(value = "删除动漫类型", notes = "删除动漫类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类型id", paramType = "Integer", dataType = "Integer", required = true)
    })
    @PostMapping("/deleteAnimeType")
    public String deleteAnimeType(@RequestParam(value = "id") int id){
        return animeTypeService.deleteAnimeType(id);
    }
}
