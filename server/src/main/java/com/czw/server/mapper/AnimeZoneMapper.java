package com.czw.server.mapper;

import com.czw.server.response.ShowAnimeZoneResponse;

import java.util.List;

public interface AnimeZoneMapper {

    List<ShowAnimeZoneResponse> showAnimeZone();

    int insertAnimeZone(String uuid, String zone_name);
}
