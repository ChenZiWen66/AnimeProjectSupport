package com.czw.server.module.mapper;

import com.czw.server.module.response.ShowAnimeTypeResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeTypeMapper {

    List<ShowAnimeTypeResponse> showAnimeType();

    int insertAnimeType(String uuid, String type_name);

    int updateAnimeType(int id, String uuid, String type_name);

    int deleteAnimeType(int id);
}
