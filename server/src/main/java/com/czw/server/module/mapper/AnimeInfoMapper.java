package com.czw.server.module.mapper;

import com.czw.server.module.response.SelectAnimeInfoByAttributeResponse;
import com.czw.server.module.response.ShowAnimeInfoResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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

    List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByName(String searchContent, int pageIndex, int page_capacity);


    int updateAnimeInfo(int id, String uuid, String anime_name, String anime_type, String anime_describe, String alias, String anime_zone, String anime_year, String anime_tag, String indexes, String update_info, String coverimg_src);

    int deleteAnimeInfo(int id);

    int getAnimeInfoCountByAttribute(String anime_type, String anime_zone, String anime_tag);

    int getAnimeInfoCountByName(String searchContent);
}
