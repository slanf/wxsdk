package com.song.wxsdk.apis.msg.uplink;

import com.song.wxsdk.utils.JsonUtil;

/**
 * Created by Song on 2017/6/26.
 * 客服接口-发送消息,消息抽象父类
 */
public abstract class BaseMsg {
    String touser;
    String msgtype;

    public BaseMsg(String touser, String msgtype) {
        this.touser = touser;
        this.msgtype = msgtype;
    }

    public String toJsonStr() {
        return JsonUtil.toJson(this);
    }
}
