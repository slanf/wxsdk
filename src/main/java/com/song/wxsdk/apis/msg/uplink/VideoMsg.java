package com.song.wxsdk.apis.msg.uplink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 视频消息
 */
public class VideoMsg extends BaseMsg {
    private Map<String,String> video = new HashMap<String, String>();

    public VideoMsg(String toUser,String media_id,String thumb_media_id,
                    String title,String description){
        super(toUser,"video");
        this.video.put("media_id",media_id);
        this.video.put("thumb_media_id",thumb_media_id);
        this.video.put("title",title);
        this.video.put("description",description);
    }
}
