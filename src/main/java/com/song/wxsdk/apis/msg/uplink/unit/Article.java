package com.song.wxsdk.apis.msg.uplink.unit;

/**
 * Created by Song on 2017/6/26.
 * news消息中单条图文消息
 */
public class Article {
    private String title;
    private String description;
    private String url;
    private String picurl;

    public Article(String title, String description, String url, String picurl) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.picurl = picurl;
    }
}
