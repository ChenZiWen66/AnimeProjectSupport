package com.czw.server.mapper;

import com.czw.server.response.ShowAnimeInfoResponse;

public interface AnimeInfoMapper {
    public ShowAnimeInfoResponse showAnimeInfo();

    public int insertAnimeInfo(String UUID,
                               String anime_name,
                               String anime_type,
                               String anime_describe,
                               String alias,
                               String anime_zone,
                               String anime_year,
                               String anime_tag,
                               String indexes,
                               String update_info,
                               String coverimg_src);
}
