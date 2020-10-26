package com.czw.server.mapper;

import com.czw.server.response.ShowAnimeTagResponse;

import java.util.List;

public interface AnimeTagMapper {

    List<ShowAnimeTagResponse> showAnimeTag();

    int insertAnimeTag(String uuid, String tag_name);

    int updateAnimeTag(int id, String uuid, String tag_name);

    int deleteAnimeTag(int id);
}
