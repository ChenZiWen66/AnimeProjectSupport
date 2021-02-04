package com.czw.server.module.services;

import com.czw.server.module.response.ShowAnimeTypeResponse;

import java.util.List;

public interface AnimeTypeService {
    public List<ShowAnimeTypeResponse> showAnimeType();
    public String insertAnimeType(String type_name);
    public String updateAnimeType(int id, String uuid, String type_name);
    public String deleteAnimeType(int id);
}
