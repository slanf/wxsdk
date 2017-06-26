package com.slanf.wxsdk.apis.wxpay.protocol.pay_protocol;

/**
 * Created By Song on 2017/3/17.
 * 根据官方扫码支付SDK，修改得到公众号支付请求数据体
 */


import com.slanf.wxsdk.apis.wxpay.config.Configure;
import com.slanf.wxsdk.utils.WxpayUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求被扫支付API需要提交的数据
 */
public class JSAPIPayReqData {

    //每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String device_info = "WEB";
    private String nonce_str = "";
    private String sign = "";
    private String sign_type = "MD5";
    private String body = "商家名称-商品类目";
    //private String detail = "";
    private String attach = "";
    private String out_trade_no = "";
    private String fee_type = "CNY";
    private int total_fee = 0;
    private String spbill_create_ip = "";
    //private String time_start = "20091225091010";
    //private String time_expire = "20091227091010";
    //private String goods_tag = "";
    private String notify_url = "";
    private String trade_type = "JSAPI";
    //private String product_id = "";
    //private String limit_pay = "";
    private String openid = "";

    public JSAPIPayReqData(String body, int total_fee, String spbill_create_ip, String notify_url, String openid,String out_trade_no,String attach) {
        this.appid = Configure.getAppid();
        this.mch_id = Configure.getMchid();
        //this.device_info = device_info;
        this.nonce_str = WxpayUtil.getRandomStringByLength(32);
        this.out_trade_no = out_trade_no;
        //this.sign_type = sign_type;
        this.body = body;
        //this.detail = detail;
        //this.attach = attach;
        //this.fee_type = fee_type;
        this.total_fee = total_fee;
        this.spbill_create_ip = spbill_create_ip;
        //this.time_start = time_start;
        //this.time_expire = time_expire;
        this.notify_url = notify_url;
        //this.trade_type = trade_type;
        this.openid = openid;
        this.attach = attach;

        this.sign = WxpayUtil.getSign(toMap(),Configure.getKey());
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }


    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    if(!field.getName().equals("sign"))
                        map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public String toXmlStr(){
        return "<xml>\n" +
                "   <appid>"+this.appid+"</appid>\n" +
                "   <device_info>"+this.device_info+"</device_info>\n" +
                "   <nonce_str>"+this.nonce_str+"</nonce_str>\n" +
                "   <mch_id>"+this.mch_id+"</mch_id>\n" +
                "   <sign>"+this.sign+"</sign>\n" +
                "   <sign_type>"+this.sign_type+"</sign_type>\n" +
                "   <body>"+this.body+"</body>\n" +
                "   <out_trade_no>"+this.out_trade_no+"</out_trade_no>\n" +
                "   <fee_type>"+this.fee_type+"</fee_type>\n" +
                "   <total_fee>"+this.total_fee+"</total_fee>\n" +
                "   <spbill_create_ip>"+this.spbill_create_ip+"</spbill_create_ip>\n" +
                "   <notify_url>"+this.notify_url+"</notify_url>\n" +
                "   <trade_type>"+this.trade_type+"</trade_type>\n" +
                "   <attach>"+this.attach+"</attach>\n" +
                "   <openid>"+this.openid+"</openid>\n" +
                "</xml>";
    }
}
