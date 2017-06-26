package com.song.wxsdk.apis.web;

/**
 * Created by Song on 2017/6/26.
 * web相关微信接口
 */
public final class WebAPI {

    private  final String AUTH_LOGIN1 = "https://open.weixin.qq.com/connect/oauth2/authorize?response_type=code&state=a13";
    private  final String SPECIAL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code";
    private  final String LONG_SPECIAL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?grant_type=refresh_token";
    private  final String USER_INFO = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN";

    private String appid;
    private String appsecret;

    public WebAPI(String appid, String appsecret) {
        this.appid = appid;
        this.appsecret = appsecret;
    }

    public String AUTH_LOGIN1(String scope,String url){
        return this.AUTH_LOGIN1+"&appid="+this.appid+
                "&redirect_uri="+"url" +
                "&scope="+scope +
                "#wechat_redirect";
    }

    public String SPECIAL_ACCESS_TOKEN(String code){
        return this.SPECIAL_ACCESS_TOKEN+"&appid="+this.appid +
                "&secret=" + this.appsecret +
                "&code=" + code;
    }

    public String LONG_SPECIAL_ACCESS_TOKEN(String refresh_token){
        return this.LONG_SPECIAL_ACCESS_TOKEN+"&appid=" + this.appid +
                "&refresh_token=" + refresh_token;
    }

    public String USER_INFO(String access_token,String openid){
        return this.USER_INFO+"&access_token="+access_token
                + "&openid="+openid;
    }
}
