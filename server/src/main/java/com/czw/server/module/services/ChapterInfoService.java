package com.czw.server.module.services;

import com.czw.server.module.mapper.ChapterInfoMapper;
import com.czw.server.module.response.ChapterInfoCountResponse;
import com.czw.server.module.response.SelectChapterInfoByParentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ChapterInfoCountResponse getChapterInfoCount() {
        ChapterInfoCountResponse chapterInfoCountResponse = new ChapterInfoCountResponse();
        chapterInfoCountResponse.setChapterInfoCount(chapterInfoMapper.getChapterInfoCount());
        return chapterInfoCountResponse;
    }
}