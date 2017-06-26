package com.slanf.wxsdk.apis.wxpay.protocol;

/**
 * Created by Song on 2017/3/22.
 * 支付结果通知，返回给微信端的数据封装结构
 */
public class NotifyRespData {

    private String return_code;
    private String return_msg;

    public NotifyRespData(String return_code, String return_msg) {
        this.return_code = return_code;
        this.return_msg = return_msg;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String toXmlStr(){
        return "<xml>\n" +
                "  <return_code><![CDATA["+this.getReturn_code()+"]]></return_code>\n" +
                "  <return_msg><![CDATA["+this.getReturn_msg()+"]]></return_msg>\n" +
                "</xml>";
    }
}
