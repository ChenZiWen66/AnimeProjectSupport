package com.czw.server.module.controller;

import com.czw.server.module.response.AnimeInfoCountResponse;
import com.czw.server.module.response.SelectAnimeInfoByAttributeResponse;
import com.czw.server.module.response.ShowAnimeInfoResponse;
import com.czw.server.module.services.AnimeInfoService;
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

@Controller
@CrossOrigin
@RequestMapping("/animeInfo")
@Api(value = "动漫信息接口",tags = "动漫信息接口")
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
    @GetMapping("/showAnimeInfo")
    @ApiOperation(value = "查询所有动漫信息", notes = "查询所有动漫信息")
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
    @ApiOperation(value = "插入动漫信息", notes = "插入动漫信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "anime_name", value = "动漫名称", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_uuid", value = "动漫uuid", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_type", value = "动漫类型", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_describe", value = "动漫描述", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "alias", value = "动漫别名", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_zone", value = "动漫地区", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_year", value = "动漫年份", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_tag", value = "动漫标签", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "indexes", value = "动漫索引", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "update_info", value = "更新信息", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "coverimg_src", value = "封面路径", paramType = "String", dataType = "String", required = true)
    })
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
    @ApiOperation(value = "根据属性查询信息数量", notes = "根据属性查询信息数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "anime_type", value = "动漫类型", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_zone", value = "动漫地区", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_tag", value = "动漫标签", paramType = "String", dataType = "String", required = true),
    })
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
    @ApiOperation(value = "根据属性查询信息", notes = "根据属性查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "anime_type", value = "动漫类型", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_zone", value = "动漫地区", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_tag", value = "动漫标签", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "current_page", value = "当前页数", paramType = "Integer", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "page_capacity", value = "页面大小", paramType = "Integer", dataType = "Integer", required = true),
    })
    public List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByAttribute(@RequestParam(value = "anime_type") String anime_type,
                                                                               @RequestParam(value = "anime_zone") String anime_zone,
                                                                               @RequestParam(value = "anime_tag") String anime_tag,
                                                                               @RequestParam(value = "current_page") int current_page,
                                                                               @RequestParam(value = "page_capacity") int page_capacity) {
        return animeInfoService.selectAnimeInfoByAttribute(anime_type, anime_zone, anime_tag, current_page, page_capacity);
    }

    @ResponseBody
    @PostMapping("/getAnimeInfoCountByName")
    @ApiOperation(value = "根据名字查询信息数量", notes = "根据名字查询信息数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchContent", value = "搜索内容", paramType = "String", dataType = "String", required = true)
    })
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
    @ApiOperation(value = "根据搜索内容模糊查询", notes = "根据搜索内容模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchContent", value = "搜索内容", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "current_page", value = "当前页数", paramType = "Integer", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "page_capacity", value = "页面大小", paramType = "Integer", dataType = "Integer", required = true)
    })
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
    @ApiOperation(value = "更新动漫信息", notes = "更新动漫信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "Integer", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "uuid", value = "动漫uuid", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_name", value = "动漫名", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_type", value = "动漫类型", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_describe", value = "动漫描述", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "alias", value = "动漫别名", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_zone", value = "动漫地区", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_year", value = "动漫年份", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "anime_tag", value = "动漫标签", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "indexes", value = "动漫索引", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "update_info", value = "更新信息", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "coverimg_src", value = "封面路径", paramType = "String", dataType = "String", required = true)
    })
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
        LOG.info("开始修改动漫信息");
        return animeInfoService.updateAnimeInfo(id, uuid, anime_name, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag, indexes, update_info, coverimg_src);
    }

    /**
     * 删除动漫信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "删除动漫信息", notes = "删除动漫信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "动漫id", paramType = "Integer", dataType = "Integer", required = true)
    })
    @PostMapping("/deleteAnimeInfo")
    public String deleteAnimeInfo(@RequestParam(value = "id") int id) {
        return animeInfoService.deleteAnimeInfo(id);
    }
}
