package com.slanf.wxsdk.apis.msg.uplink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 图片消息
 */
public class ImageMsg extends BaseMsg{
    private Map<String,String> image = new HashMap<String, String>();

    public ImageMsg(String toUser,String media_id){
        super(toUser,"image");
        this.image.put("media_id",media_id);
    }
}
