package com.slanf.wxsdk.apis.msg.uplink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 音乐消息
 */
public class MusicMsg extends BaseMsg{
    private Map<String,String> music = new HashMap<String, String>();

    public MusicMsg(String toUser,String musicurl,String thumb_media_id,
                    String title,String description,String hqmusicurl){
        super(toUser,"music");
        this.music.put("hqmusicurl",hqmusicurl);
        this.music.put("musicurl",musicurl);
        this.music.put("title",title);
        this.music.put("description",description);
        this.music.put("thumb_media_id",thumb_media_id);
    }
}
