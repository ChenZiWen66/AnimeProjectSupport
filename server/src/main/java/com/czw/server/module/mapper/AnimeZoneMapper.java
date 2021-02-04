package com.czw.server.module.mapper;

import com.czw.server.module.response.ShowAnimeZoneResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeZoneMapper {

    List<ShowAnimeZoneResponse> showAnimeZone();

    int insertAnimeZone(String uuid, String zone_name);

    int updateAnimeZone(int id, String uuid, String zone_name);

    int deleteAnimeZone(int id);
}
