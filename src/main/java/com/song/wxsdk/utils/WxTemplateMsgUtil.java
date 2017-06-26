package com.song.wxsdk.utils;

import net.sf.json.JSONObject;

import java.util.Map;

/**
 * Created by Song on 2017/5/18.
 * 微信模板消息工具
 */
public class WxTemplateMsgUtil {

    private static final String TEMPLATE_MSG_URI = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    /**
     * 发送模板消息
     * @param openid
     * @param template_id
     * @param url
     * @param data
     * @param accessToken
     * @return 0成功，1发送失败，2网络异常
     */
    /*public static int send(String openid, String template_id, String url, Map<String,DataUnit> data, String accessToken){
        TemplateMsg msg = new TemplateMsg(openid,template_id,url);
        for(String key:data.keySet()){
            msg.addData(key,data.get(key));
        }
        try {
            String backMsg = NetUtil.post(TEMPLATE_MSG_URI+accessToken, JsonUtil.toJson(msg));
            System.out.println(backMsg);
            JSONObject jsonObject = JSONObject.fromObject(backMsg);
            if(0 != (Integer) jsonObject.get("errcode")) return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }
        return 1;

    }*/
}
