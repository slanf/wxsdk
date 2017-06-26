package com.slanf.wxsdk.apis.msg;

import com.slanf.wxsdk.config.token.Token;

/**
 * Created by Song on 2017/6/26.
 * 微信发送消息API
 */
public class MsgAPI {
    /**
     * 客服消息发送接口
     */
    private static final String CUSTOMER_SERVICE_SEND_MSG = "https://api.weixin.qq.com/cgi-bin/message/custom/send";
    /**
     * 模板消息发送接口
     */
    private static final String TEMPLATE_SEND_MSG = "https://api.weixin.qq.com/cgi-bin/message/template/send";

    public static String CUSTOMER_SERVICE_SEND_MSG(){
        return CUSTOMER_SERVICE_SEND_MSG+"?access_token="+ Token.ACCESSTOKEN;
    }

    public static String TEMPLATE_SEND_MSG(){
        return TEMPLATE_SEND_MSG+"?access_token="+ Token.ACCESSTOKEN;
    }

}
