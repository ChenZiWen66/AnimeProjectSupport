package com.czw.server.services;

import com.czw.server.mapper.AnimeInfoMapper;
import com.czw.server.response.ShowAnimeInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnimeInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeInfoService.class);
    @Autowired
    AnimeInfoMapper animeInfoMapper;

    public ShowAnimeInfoResponse showAnimeInfo() {
        return animeInfoMapper.showAnimeInfo();
    }

    public String insertAnimeInfo(String anime_name,
                                  String anime_type,
                                  String anime_describe,
                                  String alias,
                                  String anime_zone,
                                  String anime_year,
                                  String anime_tag,
                                  String indexes,
                                  String update_info,
                                  String coverimg_src) {
        String uuid = UUID.randomUUID().toString();
        animeInfoMapper.insertAnimeInfo(uuid, anime_name, anime_type, anime_describe, alias, anime_zone, anime_year, anime_tag, indexes, update_info, coverimg_src);
        return "插入成功";
    }

}
