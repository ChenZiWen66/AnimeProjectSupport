package com.czw.server.module.services;

import com.czw.server.module.response.AnimeInfoCountResponse;
import com.czw.server.module.response.SelectAnimeInfoByAttributeResponse;
import com.czw.server.module.response.ShowAnimeInfoResponse;

import java.util.List;

public interface AnimeInfoService {
    public List<ShowAnimeInfoResponse> showAnimeInfo();

    public String insertAnimeInfo(String anime_name,
                                  String anime_uuid,
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
                                                                               int current_page,
                                                                               int page_capacity);

    public List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByName(String searchContent, int current_page, int page_capacity);

    public String updateAnimeInfo(int id, String uuid, String anime_name, String anime_type, String anime_describe, String alias, String anime_zone, String anime_year, String anime_tag, String indexes, String update_info, String coverimg_src);

    public String deleteAnimeInfo(int id);

    public AnimeInfoCountResponse getAnimeInfoCountByAttribute(String anime_type, String anime_zone, String anime_tag);

    public AnimeInfoCountResponse getAnimeInfoCountByName(String searchContent);
}
