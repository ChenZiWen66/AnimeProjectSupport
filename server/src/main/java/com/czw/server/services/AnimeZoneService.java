package com.czw.server.services;

import com.czw.server.mapper.AnimeZoneMapper;
import com.czw.server.response.ShowAnimeZoneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimeZoneService {
    @Autowired
    private AnimeZoneMapper animeZoneMapper;

    public List<ShowAnimeZoneResponse> showAnimeZone() {
        return animeZoneMapper.showAnimeZone();
    }

    public String insertAnimeZone(String zone_name) {
        String uuid = UUID.randomUUID().toString();
        animeZoneMapper.insertAnimeZone(uuid,zone_name);
        return "插入成功";
    }
}
