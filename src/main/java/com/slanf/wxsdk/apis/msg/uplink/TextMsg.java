package com.slanf.wxsdk.apis.msg.uplink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 文本消息
 */
public class TextMsg extends BaseMsg {

    private Map<String,String> text = new HashMap<String, String>();

    public TextMsg(String toUser,String content){
        super(toUser,"text");
        this.text.put("content",content);
    }
}
