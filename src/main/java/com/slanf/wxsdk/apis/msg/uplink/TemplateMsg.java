package com.slanf.wxsdk.apis.msg.uplink;

import com.slanf.wxsdk.apis.msg.uplink.unit.ValueAndColor;
import com.slanf.wxsdk.utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 模板消息
 */
public class TemplateMsg {
    private String touser;
    private String template_id;
    private String url;
    private Map<String,ValueAndColor> data = new HashMap<String, ValueAndColor>();

    public TemplateMsg(String touser, String template_id, String url) {
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
    }

    public void addPair(String keyword,String value,String color){
        this.data.put(keyword,new ValueAndColor(value, color));
    }

    public void addPair(String keyword,String value){
        this.data.put(keyword,new ValueAndColor(value));
    }

    public String toJsonStr(){
        return JsonUtil.toJson(this);
    }
}
