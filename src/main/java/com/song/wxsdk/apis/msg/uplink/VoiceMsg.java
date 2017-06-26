package com.song.wxsdk.apis.msg.uplink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 语音消息
 */
public class VoiceMsg extends BaseMsg {
    private Map<String,String> voice = new HashMap<String, String>();

    public VoiceMsg(String toUser,String media_id){
        super(toUser,"voice");
        this.voice.put("media_id",media_id);
    }
}
