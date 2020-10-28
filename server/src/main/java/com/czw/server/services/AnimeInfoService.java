package com.czw.server.services;

import com.czw.server.mapper.AnimeInfoMapper;
import com.czw.server.response.SelectAnimeInfoByAttributeResponse;
import com.czw.server.response.ShowAnimeInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimeInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeInfoService.class);
    @Autowired
    AnimeInfoMapper animeInfoMapper;

    public List<ShowAnimeInfoResponse> showAnimeInfo() {
        return animeInfoMapper.showAnimeInfo();
    }

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
                                  String coverimg_src) {
        animeInfoMapper.insertAnimeInfo(anime_uuid, anime_name, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag, indexes, update_info, coverimg_src);
        return "插入成功";
    }

    public List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByAttribute(String anime_type,
                                                                               String anime_zone,
                                                                               String anime_tag) {
        return animeInfoMapper.selectAnimeInfoByAttribute(anime_type, anime_zone, anime_tag);
    }

    public List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByName(String searchContent) {
        return animeInfoMapper.selectAnimeInfoByName(searchContent);
    }

    public String updateAnimeInfo(int id, String uuid, String anime_name, String anime_type, String anime_describe, String alias, String anime_zone, String anime_year, String anime_tag, String indexes, String update_info, String coverimg_src) {
        animeInfoMapper.updateAnimeInfo(id, uuid, anime_name, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag, indexes, update_info, coverimg_src);
        return "修改成功";
    }

    public String deleteAnimeInfo(int id) {
        animeInfoMapper.deleteAnimeInfo(id);
        return "删除成功";
    }
}
