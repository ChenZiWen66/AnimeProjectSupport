package com.czw.server.module.services;

import com.czw.server.module.response.ShowAnimeTagResponse;

import java.util.List;

public interface AnimeTagService {
    public List<ShowAnimeTagResponse> showAnimeTag();
    public String insertAnimeTag(String tag_name);
    public String updateAnimeTag(int id, String uuid, String tag_name);
    public String deleteAnimeTag(int id);
}
