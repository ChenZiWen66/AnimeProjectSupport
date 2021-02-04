package com.czw.server.module.mapper;

import com.czw.server.module.response.SelectChapterInfoByParentResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterInfoMapper {
    List<SelectChapterInfoByParentResponse> selectChapterInfoByParent(String parentUUID);

    int insertChapterInfo(String chapter_name, String chapter_video_src, String chapter_cover_src, String parent, String uuid);

    int updateChapterInfo(int id, String chapter_name, String chapter_video_src, String chapter_cover_src, String parent, String uuid);

    int deleteChapterInfo(int id);

    int getChapterInfoCount();
}
