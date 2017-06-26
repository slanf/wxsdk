package com.slanf.wxsdk.apis.wxpay.protocol.mchpay_protocol;


import com.slanf.wxsdk.apis.wxpay.config.Configure;
import com.slanf.wxsdk.config.ConfigInfo;
import com.slanf.wxsdk.utils.WxpayUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/3/22.
 * 企业向用户付款时的数据封装
 * 字段意义参考https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2
 */
public class MchpayReqData {

    private String mch_appid;
    private String mchid;
    private String nonce_str;
    private String sign;
    private String partner_trade_no;
    private String openid;
    private String check_name = "NO_CHECK";
    private int amount;
    private String desc = "用户积分提现";
    private String spbill_create_ip = "192.168.0.1";

    public MchpayReqData(String openid, int amount, String spbill_create_ip) {
        this.mch_appid = ConfigInfo.APPID;
        this.mchid = Configure.getMchid();
        this.nonce_str = WxpayUtil.getRandomStringByLength(32);
        this.partner_trade_no = WxpayUtil.getOutTradeNo();
        this.openid = openid;
        this.amount = amount;
        this.spbill_create_ip = spbill_create_ip;
        this.sign = WxpayUtil.getSign(toMap(),Configure.getKey());
    }

    public String toXmlString(){
        return "<xml>\n" +
                "<mch_appid>"+this.mch_appid+"</mch_appid>\n" +
                "<mchid>"+this.mchid+"</mchid>\n" +
                "<nonce_str>"+this.nonce_str+"</nonce_str>\n" +
                "<partner_trade_no>"+this.partner_trade_no+"</partner_trade_no>\n" +
                "<openid>"+this.openid+"</openid>\n" +
                "<check_name>"+this.check_name+"</check_name>\n" +
                "<amount>"+this.amount+"</amount>\n" +
                "<desc>"+this.desc+"</desc>\n" +
                "<spbill_create_ip>"+this.spbill_create_ip+"</spbill_create_ip>\n" +
                "<sign>"+this.sign+"</sign>\n" +
                "</xml>";
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

    public String getMch_appid() {
        return mch_appid;
    }

    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
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

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCheck_name() {
        return check_name;
    }

    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }
}
