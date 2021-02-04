package com.czw.server.module.controller;

import com.czw.server.module.response.ChapterInfoCountResponse;
import com.czw.server.module.response.SelectChapterInfoByParentResponse;
import com.czw.server.module.services.ChapterInfoService;
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
@RequestMapping("/chapterInfo")
@Api(value = "剧集信息接口",tags = "剧集信息接口")
public class ChapterInfoController {
    private static final Logger LOG = LoggerFactory.getLogger(ChapterInfoController.class);

    @Autowired
    private ChapterInfoService chapterInfoService;

    /**
     * 获取剧集数量
     * @return
     */
    @GetMapping("/getChapterInfoCount")
    @ApiOperation(value = "获取剧集数量", notes = "获取剧集信息数量")
    @ResponseBody
    public ChapterInfoCountResponse getChapterInfoCount(){
        LOG.info("获取剧集的数量");
        return  chapterInfoService.getChapterInfoCount();
    }

    /**
     * 根据parent的UUID搜索章节
     *
     * @param parentUUID
     * @return
     */
    @ResponseBody
    @PostMapping("/selectChapterInfoByParent")
    @ApiOperation(value = "获取剧集", notes = "根据动漫的UUID搜索剧集的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentUUID", value = "动漫的UUID", paramType = "String", dataType = "String", required = true)
    })
    public List<SelectChapterInfoByParentResponse> selectChapterInfoByParent(@RequestParam(value = "parentUUID") String parentUUID) {
        LOG.info("搜索动漫UUID"+parentUUID);
        return chapterInfoService.selectChapterInfoByParent(parentUUID);
    }

    /**
     * 插入章节信息
     *
     * @param chapter_name
     * @param chapter_video_src
     * @param chapter_cover_src
     * @param parent
     * @return
     */
    @PostMapping("/insertChapterInfo")
    @ApiOperation(value = "添加剧集信息", notes = "插入剧集信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "chapter_name", value = "剧集名称", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "chapter_video_src", value = "剧集视频路径", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "chapter_cover_src", value = "剧集封面路径", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "parent", value = "动漫uuid", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "uuid", value = "剧集uuid", paramType = "String", dataType = "String", required = true),
    })
    @ResponseBody
    public String insertChapterInfo(@RequestParam(value = "chapter_name") String chapter_name,
                                    @RequestParam(value = "chapter_video_src") String chapter_video_src,
                                    @RequestParam(value = "chapter_cover_src") String chapter_cover_src,
                                    @RequestParam(value = "parent") String parent,
                                    @RequestParam(value = "uuid") String uuid) {
        LOG.info("开始插入章节信息");
        return chapterInfoService.insertChapterInfo(chapter_name, chapter_video_src, chapter_cover_src, parent,uuid);
    }

    /**
     * 修改章节信息
     *
     * @param id
     * @param chapter_name
     * @param chapter_video_src
     * @param chapter_cover_src
     * @param parent
     * @return
     */
    @PostMapping("/updateChapterInfo")
    @ApiOperation(value = "修改剧集信息", notes = "修改剧集信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "剧集id", paramType = "Integer", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "chapter_name", value = "剧集名称", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "chapter_video_src", value = "剧集视频路径", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "chapter_cover_src", value = "剧集封面路径", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "parent", value = "动漫uuid", paramType = "String", dataType = "String", required = true),
            @ApiImplicitParam(name = "uuid", value = "剧集uuid", paramType = "String", dataType = "String", required = true),
    })
    @ResponseBody
    public String updateChapterInfo(@RequestParam(value = "id") int id,
                                    @RequestParam(value = "chapter_name") String chapter_name,
                                    @RequestParam(value = "chapter_video_src") String chapter_video_src,
                                    @RequestParam(value = "chapter_cover_src") String chapter_cover_src,
                                    @RequestParam(value = "parent") String parent,
                                    @RequestParam(value = "uuid") String uuid) {
        return chapterInfoService.updateChapterInfo(id, chapter_name, chapter_video_src, chapter_cover_src, parent, uuid);
    }

    /**
     * 删除章节信息
     * @param id
     * @return
     */
    @PostMapping("/deleteChapterInfo")
    @ApiOperation(value = "删除剧集信息", notes = "删除剧集信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "剧集id", paramType = "Integer", dataType = "Integer", required = true)
    })
    @ResponseBody
    public String deleteChapterInfo(@RequestParam(value = "id") int id) {
        return chapterInfoService.deleteChapterInfo(id);
    }
}
