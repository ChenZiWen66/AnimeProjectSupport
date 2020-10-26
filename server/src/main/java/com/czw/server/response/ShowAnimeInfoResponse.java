package com.czw.server.response;

/**
 * 查询所有动漫信息的返回体
 */
public class ShowAnimeInfoResponse {
    private int id;
    private String UUID;
    private String anime_name;
    private String anime_type;
    private String anime_describe;
    private String alias;
    private String anime_zone;
    private String anime_year;
    private String anime_tag;
    private String indexes;
    private String update_info;
    private String coverimg_src;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getAnime_name() {
        return anime_name;
    }

    public void setAnime_name(String anime_name) {
        this.anime_name = anime_name;
    }

    public String getAnime_type() {
        return anime_type;
    }

    public void setAnime_type(String anime_type) {
        this.anime_type = anime_type;
    }

    public String getAnime_describe() {
        return anime_describe;
    }

    public void setAnime_describe(String anime_describe) {
        this.anime_describe = anime_describe;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAnime_zone() {
        return anime_zone;
    }

    public void setAnime_zone(String anime_zone) {
        this.anime_zone = anime_zone;
    }

    public String getAnime_year() {
        return anime_year;
    }

    public void setAnime_year(String anime_year) {
        this.anime_year = anime_year;
    }

    public String getAnime_tag() {
        return anime_tag;
    }

    public void setAnime_tag(String anime_tag) {
        this.anime_tag = anime_tag;
    }

    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    public String getUpdate_info() {
        return update_info;
    }

    public void setUpdate_info(String update_info) {
        this.update_info = update_info;
    }

    public String getCoverimg_src() {
        return coverimg_src;
    }

    public void setCoverimg_src(String coverimg_src) {
        this.coverimg_src = coverimg_src;
    }
}
