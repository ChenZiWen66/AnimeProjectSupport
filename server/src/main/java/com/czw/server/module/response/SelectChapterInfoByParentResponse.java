package com.czw.server.module.response;

public class SelectChapterInfoByParentResponse {
    private int id;
    private String chapter_name;
    private String chapter_video_src;
    private String chapter_cover_src;
    private String parent;
    private String uuid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getChapter_video_src() {
        return chapter_video_src;
    }

    public void setChapter_video_src(String chapter_video_src) {
        this.chapter_video_src = chapter_video_src;
    }

    public String getChapter_cover_src() {
        return chapter_cover_src;
    }

    public void setChapter_cover_src(String chapter_cover_src) {
        this.chapter_cover_src = chapter_cover_src;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
