package com.song.wxsdk.apis.msg;

import com.song.wxsdk.apis.msg.uplink.BaseMsg;
import com.song.wxsdk.apis.msg.uplink.TemplateMsg;
import com.song.wxsdk.utils.NetUtil;

import java.io.IOException;

/**
 * Created by Song on 2017/6/26.
 * 微信消息接口
 */
public class MsgSDK {
    /**
     * 客服消息接口-发送消息
     * @param msg
     * @throws IOException
     */
    public  void send(BaseMsg msg) throws IOException{
        NetUtil.post(
            MsgAPI.CUSTOMER_SERVICE_SEND_MSG(),
                msg.toJsonStr()
        );
    }

    /**
     * 发送模板消息
     * @param msg
     * @throws IOException
     */
    public  void send(TemplateMsg msg) throws IOException{
        NetUtil.post(
                MsgAPI.TEMPLATE_SEND_MSG(),
                msg.toJsonStr()
        );
    }
}
