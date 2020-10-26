package com.czw.server.services;

import com.czw.server.mapper.AnimeTypeMapper;
import com.czw.server.response.ShowAnimeTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimeTypeService {
    @Autowired
    private AnimeTypeMapper animeTypeMapper;

    public List<ShowAnimeTypeResponse> showAnimeType() {
        return animeTypeMapper.showAnimeType();
    }

    public String insertAnimeType(String type_name) {
        String uuid = UUID.randomUUID().toString();
        animeTypeMapper.insertAnimeType(uuid,type_name);
        return "插入成功";
    }

    public String updateAnimeType(int id, String uuid, String type_name) {
        animeTypeMapper.updateAnimeType(id,uuid,type_name);
        return "修改成功";
    }

    public String deleteAnimeType(int id) {
        animeTypeMapper.deleteAnimeType(id);
        return "删除成功";
    }
}
