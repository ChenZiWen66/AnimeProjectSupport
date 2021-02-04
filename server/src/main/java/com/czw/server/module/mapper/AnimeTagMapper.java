package com.czw.server.module.mapper;

import com.czw.server.module.response.ShowAnimeTagResponse;

import java.util.List;

public interface AnimeTagMapper {

    List<ShowAnimeTagResponse> showAnimeTag();

    int insertAnimeTag(String uuid, String tag_name);

    int updateAnimeTag(int id, String uuid, String tag_name);

    int deleteAnimeTag(int id);
}
