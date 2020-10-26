package com.czw.server.services;

import com.czw.server.mapper.AnimeInfoMapper;
import com.czw.server.response.ShowAnimeInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimeInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(AnimeInfoService.class);
    @Autowired
    AnimeInfoMapper animeInfoMapper;

    public ShowAnimeInfoResponse showAnimeInfo() {
        return animeInfoMapper.showAnimeInfo();
    }

}
