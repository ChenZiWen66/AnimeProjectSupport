package com.czw.server.module.controller;

import com.czw.server.module.response.ShowAnimeTagResponse;
import com.czw.server.module.services.AnimeTagService;
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
@RequestMapping("/animeTag")
@Api(value = "动漫标签接口",tags = "动漫标签接口")
public class AnimeTagController {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeTagController.class);

    @Autowired
    private AnimeTagService animeTagServiceImpl;

    @GetMapping("/showAnimeTag")
    @ApiOperation(value = "显示动漫标签", notes = "显示所有的动漫标签")
    @ResponseBody
    public List<ShowAnimeTagResponse> showAnimeTag() {
        return animeTagServiceImpl.showAnimeTag();
    }

    @ResponseBody
    @PostMapping("/insertAnimeTag")
    @ApiOperation(value = "添加动漫标签", notes = "添加动漫标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tag_name", value = "标签名称", paramType = "String", dataType = "String", required = true)
    })
    public String insertAnimeTag(@RequestParam(value = "tag_name") String tag_name) {
        return animeTagServiceImpl.insertAnimeTag(tag_name);
    }

    @ResponseBody
    @PostMapping("/updateAnimeTag")
    @ApiOperation(value = "更新动漫标签", notes = "更新动漫标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签id", paramType = "Integer", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "uuid", value = "标签uuid", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "tag_name", value = "标签名", paramType = "String", dataType = "String", required = true),
    })
    public String updateAnimeTag(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "uuid") String uuid,
                                  @RequestParam(value = "tag_name") String tag_name) {
        return animeTagServiceImpl.updateAnimeTag(id, uuid, tag_name);
    }

    @ResponseBody
    @PostMapping("/deleteAnimeTag")
    @ApiOperation(value = "删除动漫标签", notes = "删除标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签id", paramType = "Integer", dataType = "Integer", required = true)
    })
    public String deleteAnimeTag(@RequestParam(value = "id") int id){
        return animeTagServiceImpl.deleteAnimeTag(id);
    }
}
