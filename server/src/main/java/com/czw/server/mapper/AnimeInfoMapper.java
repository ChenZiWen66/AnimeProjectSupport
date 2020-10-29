package com.czw.server.mapper;

import com.czw.server.response.SelectAnimeInfoByAttributeResponse;
import com.czw.server.response.ShowAnimeInfoResponse;

import java.util.List;

public interface AnimeInfoMapper {
    public List<ShowAnimeInfoResponse> showAnimeInfo();

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

    public List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByAttribute(String anime_type,
                                                                               String anime_zone,
                                                                               String anime_tag,
                                                                               int pageIndex,
                                                                               int page_capacity);

    List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByName(String searchContent);


    int updateAnimeInfo(int id, String uuid, String anime_name, String anime_type, String anime_describe, String alias, String anime_zone, String anime_year, String anime_tag, String indexes, String update_info, String coverimg_src);

    int deleteAnimeInfo(int id);

    int getAnimeInfoCountByAttribute(String anime_type, String anime_zone, String anime_tag);
}
