package com.czw.server.module.controller;

import com.czw.server.module.response.ChapterInfoCountResponse;
import com.czw.server.module.response.SelectChapterInfoByParentResponse;
import com.czw.server.module.services.impl.ChapterInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class ChapterInfoController {
    private static final Logger LOG = LoggerFactory.getLogger(ChapterInfoController.class);

    @Autowired
    private ChapterInfoServiceImpl chapterInfoServiceImpl;

    /**
     * 获取剧集数量
     * @return
     */
    @RequestMapping("/getChapterInfoCount")
    @ResponseBody
    public ChapterInfoCountResponse getChapterInfoCount(){
        LOG.info("获取剧集的数量");
        return  chapterInfoServiceImpl.getChapterInfoCount();
    }

    /**
     * 根据parent的UUID搜索章节
     *
     * @param parentUUID
     * @return
     */
    @ResponseBody
    @PostMapping("/selectChapterInfoByParent")
    public List<SelectChapterInfoByParentResponse> selectChapterInfoByParent(@RequestParam(value = "parentUUID") String parentUUID) {
        LOG.info("搜索动漫UUID"+parentUUID);
        return chapterInfoServiceImpl.selectChapterInfoByParent(parentUUID);
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
    @ResponseBody
    public String insertChapterInfo(@RequestParam(value = "chapter_name") String chapter_name,
                                    @RequestParam(value = "chapter_video_src") String chapter_video_src,
                                    @RequestParam(value = "chapter_cover_src") String chapter_cover_src,
                                    @RequestParam(value = "parent") String parent,
                                    @RequestParam(value = "uuid") String uuid) {
        LOG.info("开始插入章节信息");
        return chapterInfoServiceImpl.insertChapterInfo(chapter_name, chapter_video_src, chapter_cover_src, parent,uuid);
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
    @ResponseBody
    public String updateChapterInfo(@RequestParam(value = "id") int id,
                                    @RequestParam(value = "chapter_name") String chapter_name,
                                    @RequestParam(value = "chapter_video_src") String chapter_video_src,
                                    @RequestParam(value = "chapter_cover_src") String chapter_cover_src,
                                    @RequestParam(value = "parent") String parent,
                                    @RequestParam(value = "uuid") String uuid) {
        return chapterInfoServiceImpl.updateChapterInfo(id, chapter_name, chapter_video_src, chapter_cover_src, parent, uuid);
    }

    /**
     * 删除章节信息
     * @param id
     * @return
     */
    @PostMapping("/deleteChapterInfo")
    @ResponseBody
    public String deleteChapterInfo(@RequestParam(value = "id") int id) {
        return chapterInfoServiceImpl.deleteChapterInfo(id);
    }
}
