package com.czw.server.module.services;

import com.czw.server.module.response.ShowAnimeZoneResponse;

import java.util.List;

public interface AnimeZoneService {
    public List<ShowAnimeZoneResponse> showAnimeZone();
    public String insertAnimeZone(String zone_name);
    public String updateAnimeZone(int id, String uuid, String zone_name);
    public String deleteAnimeZone(int id);
}
