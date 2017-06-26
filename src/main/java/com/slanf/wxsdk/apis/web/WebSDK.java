package com.slanf.wxsdk.apis.web;

import com.slanf.wxsdk.apis.web.dto.WxUser;
import com.slanf.wxsdk.config.ConfigInfo;
import com.slanf.wxsdk.utils.JsonUtil;
import com.slanf.wxsdk.utils.NetUtil;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Song on 2017/6/26.
 * 微信web开发SDK接口
 */
public final class WebSDK {
    /**
     * 进入微信授权登录页面
     * @param response
     * @param scope 授权方式
     * @param url 回调接口
     * @throws IOException
     */
    public  void toAuthPage(HttpServletResponse response,String scope,String url) throws IOException{
        WebAPI webAPI = new WebAPI(ConfigInfo.APPID,
                ConfigInfo.APPSECRET);
        String auth_login = webAPI.AUTH_LOGIN1(scope,url);
        response.sendRedirect(auth_login);
    }

    /**
     * 授权登录成功，获取用户信息
     * 当且仅当scope为 SCOPE.SNSAPI_USERINFO
     * @param code
     * @param isRefresh
     * @return
     */
    public  WxUser getAuthUserInfo(String code,boolean isRefresh){
        WebAPI webAPI = new WebAPI(ConfigInfo.APPID,
                ConfigInfo.APPSECRET);
        JSONObject jo = JSONObject.fromObject(NetUtil.get(webAPI.SPECIAL_ACCESS_TOKEN(code)));

        if(isRefresh){
            jo = JSONObject.fromObject(NetUtil.get(webAPI.LONG_SPECIAL_ACCESS_TOKEN(jo.getString("refresh_token"))));
        }

        WxUser wxUser = JsonUtil.toObject(NetUtil.get(webAPI.USER_INFO(jo.getString("access_token"),
                jo.getString("openid"))),WxUser.class);

        return wxUser;
    }


}
