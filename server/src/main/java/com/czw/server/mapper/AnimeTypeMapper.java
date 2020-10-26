package com.czw.server.mapper;

import com.czw.server.response.ShowAnimeTypeResponse;

import java.util.List;

public interface AnimeTypeMapper {

    List<ShowAnimeTypeResponse> showAnimeType();

    int insertAnimeType(String uuid, String type_name);

    int updateAnimeType(int id, String uuid, String type_name);

    int deleteAnimeType(int id);
}
