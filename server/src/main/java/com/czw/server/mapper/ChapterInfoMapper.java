package com.czw.server.mapper;

import com.czw.server.response.SelectChapterInfoByParentResponse;

import java.util.List;

public interface ChapterInfoMapper {
    List<SelectChapterInfoByParentResponse> selectChapterInfoByParent(String parentUUID);

    int insertChapterInfo(String chapter_name, String chapter_video_src, String chapter_cover_src, String parent, String uuid);

    int updateChapterInfo(int id, String chapter_name, String chapter_video_src, String chapter_cover_src, String parent, String uuid);

    int deleteChapterInfo(int id);
}
