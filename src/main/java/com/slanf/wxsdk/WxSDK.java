package com.slanf.wxsdk;

import com.slanf.wxsdk.apis.msg.MsgSDK;
import com.slanf.wxsdk.apis.web.WebSDK;
import com.slanf.wxsdk.apis.wxpay.PaySDK;
import com.slanf.wxsdk.config.ConfigInfo;
import com.slanf.wxsdk.config.token.Token;

import java.util.concurrent.TimeUnit;

/**
 * Created by Song on 2017/6/25.
 * 提供对外接口
 */
public class WxSDK {
    /**
     * 微信授权登录，用户信息获取
     */
    public static final WebSDK WEB_SDK= new WebSDK();
    /**
     * 发送消息接口
     */
    public static final MsgSDK MSG_SDK = new MsgSDK();
    /**
     * 微信支付接口
     */
    public static final PaySDK PAY_SDK = new PaySDK();

    /**
     * 加载properties文件，完成配置参数初始化
     * 完成token获取
     */
    public static void init() throws Exception{
        ConfigInfo.init();
        Token.init();
        TimeUnit.SECONDS.sleep(2);
    }
    public static void init(String path) throws Exception {
        ConfigInfo.init(path);
        Token.init();
        TimeUnit.SECONDS.sleep(2);
    }

}
