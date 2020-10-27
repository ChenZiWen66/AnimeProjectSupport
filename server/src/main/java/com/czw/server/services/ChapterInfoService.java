package com.czw.server.services;

import com.czw.server.controller.ChapterInfoController;
import com.czw.server.mapper.ChapterInfoMapper;
import com.czw.server.response.SelectChapterInfoByParentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChapterInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(ChapterInfoService.class);

    @Autowired
    private ChapterInfoMapper chapterInfoMapper;

    public List<SelectChapterInfoByParentResponse> selectChapterInfoByParent(String parentUUID) {
        return chapterInfoMapper.selectChapterInfoByParent(parentUUID);
    }

    public String insertChapterInfo(String chapter_name, String chapter_video_src, String chapter_cover_src, String parent,String uuid) {
        chapterInfoMapper.insertChapterInfo(chapter_name, chapter_video_src, chapter_cover_src, parent, uuid);
        return "插入成功";
    }

    public String updateChapterInfo(int id, String chapter_name, String chapter_video_src, String chapter_cover_src, String parent, String uuid) {
        chapterInfoMapper.updateChapterInfo(id, chapter_name, chapter_video_src, chapter_cover_src, parent, uuid);
        return "更新成功";
    }

    public String deleteChapterInfo(int id) {
        chapterInfoMapper.deleteChapterInfo(id);
        return "删除成功";
    }
}
