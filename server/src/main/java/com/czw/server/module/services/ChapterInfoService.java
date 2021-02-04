package com.czw.server.module.services;

import com.czw.server.module.response.ChapterInfoCountResponse;
import com.czw.server.module.response.SelectChapterInfoByParentResponse;

import java.util.List;

public interface ChapterInfoService {
    public List<SelectChapterInfoByParentResponse> selectChapterInfoByParent(String parentUUID);
    public String insertChapterInfo(String chapter_name, String chapter_video_src, String chapter_cover_src, String parent,String uuid);
    public String updateChapterInfo(int id, String chapter_name, String chapter_video_src, String chapter_cover_src, String parent, String uuid);
    public String deleteChapterInfo(int id);
    public ChapterInfoCountResponse getChapterInfoCount();
}
