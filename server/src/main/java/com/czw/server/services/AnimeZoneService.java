package com.czw.server.services;

import com.czw.server.mapper.AnimeZoneMapper;
import com.czw.server.response.ShowAnimeZoneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeZoneService {
    @Autowired
    private AnimeZoneMapper animeZoneMapper;

    public List<ShowAnimeZoneResponse> showAnimeZone() {
        return animeZoneMapper.showAnimeZone();
    }
}
