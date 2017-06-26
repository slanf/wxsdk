package com.slanf.wxsdk.apis.msg.uplink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 图文消息（点击跳转到图文消息页面）
 */
public class MpnewsMsg extends BaseMsg{
    private Map<String,Object> mpnews = new HashMap<String, Object>();

    public MpnewsMsg(String toUser,String media_id){
        super(toUser,"mpnews");
        this.mpnews.put("media_id",media_id);
    }
}
