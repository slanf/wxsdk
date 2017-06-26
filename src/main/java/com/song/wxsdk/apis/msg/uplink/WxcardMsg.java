package com.song.wxsdk.apis.msg.uplink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 微信卡券
 */
public class WxcardMsg extends BaseMsg {
    private Map<String,String> wxcard = new HashMap<String, String>();

    public WxcardMsg(String toUser,String card_id){
        super(toUser,"wxcard");
        this.wxcard.put("card_id",card_id);
    }
}
