package com.czw.server.module.services.impl;

import com.czw.server.module.mapper.AnimeInfoMapper;
import com.czw.server.module.response.AnimeInfoCountResponse;
import com.czw.server.module.response.SelectAnimeInfoByAttributeResponse;
import com.czw.server.module.response.ShowAnimeInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AnimeInfoService")
public class AnimeInfoServiceImpl implements com.czw.server.module.services.AnimeInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeInfoServiceImpl.class);
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
                                                                               String anime_tag,
                                                                               int current_page,
                                                                               int page_capacity) {
        int pageIndex = (current_page - 1) * page_capacity;
        return animeInfoMapper.selectAnimeInfoByAttribute(anime_type, anime_zone, anime_tag, pageIndex, page_capacity);
    }

    public List<SelectAnimeInfoByAttributeResponse> selectAnimeInfoByName(String searchContent, int current_page, int page_capacity) {
        int pageIndex = (current_page - 1) * page_capacity;
        return animeInfoMapper.selectAnimeInfoByName(searchContent, pageIndex, page_capacity);
    }

    public String updateAnimeInfo(int id, String uuid, String anime_name, String anime_type, String anime_describe, String alias, String anime_zone, String anime_year, String anime_tag, String indexes, String update_info, String coverimg_src) {
        animeInfoMapper.updateAnimeInfo(id, uuid, anime_name, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag, indexes, update_info, coverimg_src);
        return "修改成功";
    }

    public String deleteAnimeInfo(int id) {
        animeInfoMapper.deleteAnimeInfo(id);
        return "删除成功";
    }

    public AnimeInfoCountResponse getAnimeInfoCountByAttribute(String anime_type, String anime_zone, String anime_tag) {
        AnimeInfoCountResponse animeInfoCountResponse = new AnimeInfoCountResponse();
        animeInfoCountResponse.setAnimeInfoCount(animeInfoMapper.getAnimeInfoCountByAttribute(anime_type, anime_zone, anime_tag));
        return animeInfoCountResponse;
    }

    public AnimeInfoCountResponse getAnimeInfoCountByName(String searchContent) {
        AnimeInfoCountResponse animeInfoCountResponse = new AnimeInfoCountResponse();
        animeInfoCountResponse.setAnimeInfoCount(animeInfoMapper.getAnimeInfoCountByName(searchContent));
        return animeInfoCountResponse;
    }
}
