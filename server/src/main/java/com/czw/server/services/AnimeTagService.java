package com.czw.server.services;

import com.czw.server.mapper.AnimeTagMapper;
import com.czw.server.response.ShowAnimeTagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimeTagService {
    @Autowired
    private AnimeTagMapper animeTagMapper;

    public List<ShowAnimeTagResponse> showAnimeTag() {
        return animeTagMapper.showAnimeTag();
    }

    public String insertAnimeTag(String tag_name) {
        String uuid = UUID.randomUUID().toString();
        animeTagMapper.insertAnimeTag(uuid,tag_name);
        return "插入成功";
    }

    public String updateAnimeTag(int id, String uuid, String tag_name) {
        animeTagMapper.updateAnimeTag(id,uuid,tag_name);
        return "修改成功";
    }

    public String deleteAnimeTag(int id) {
        animeTagMapper.deleteAnimeTag(id);
        return "删除成功";
    }
}
