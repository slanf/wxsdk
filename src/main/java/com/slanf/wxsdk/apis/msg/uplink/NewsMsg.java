package com.slanf.wxsdk.apis.msg.uplink;

import com.slanf.wxsdk.apis.msg.uplink.unit.Article;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 图文消息
 */
public class NewsMsg extends BaseMsg{
    private Map<String,Object> news = new HashMap<String, Object>();

    public NewsMsg(String toUser,String musicurl,String thumb_media_id,
                    String title,String description,String hqmusicurl){
        super(toUser,"news");
        this.news.put("articles",new Article[8]);
    }

    private boolean addArtical(String title, String description,
                               String url, String picurl){
        Article [] articles = (Article[]) this.news.get("articles");
        if(articles.length>7) return false;
        articles[articles.length-1] = new Article(
                title, description, url, picurl
        );
        this.news.put("articles",articles);
        return true;
    }
}
