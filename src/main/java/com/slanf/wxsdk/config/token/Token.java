package com.slanf.wxsdk.config.token;

import com.slanf.wxsdk.config.ConfigInfo;
import com.slanf.wxsdk.utils.NetUtil;
import net.sf.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Song on 2017/3/16.
 * 定时任务
 * 1. 用于定时查询更新微信access_token
 * 2. 每天凌晨三点，遍历数据库，将还未确认收货的订单置为已收货，且返还用户积分
 */
public class Token {
    public static volatile String ACCESSTOKEN;
    public static volatile String JSAPITICKET;

    private static void getAndUpdateAccessToken(){
        try {
            JSONObject jsonObject = JSONObject.fromObject(NetUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + ConfigInfo.APPID + "&secret=" + ConfigInfo.APPSECRET));
            String access_token = jsonObject.getString("access_token");
            ACCESSTOKEN = access_token;
            //jspspi_ticket
            JSONObject jsonObject1 = JSONObject.fromObject(NetUtil.get("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi"));
            String jsapi_ticket = jsonObject1.getString("ticket");
            JSAPITICKET =jsapi_ticket;
            System.out.println("access_token: " + access_token + "  jsapi_ticket: " + jsapi_ticket);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void init(){
        Timer timer = new Timer("token",true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getAndUpdateAccessToken();
            }
        },0,1800000);
    }
}
