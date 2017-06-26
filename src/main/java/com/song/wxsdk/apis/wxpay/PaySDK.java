package com.song.wxsdk.apis.wxpay;

import com.song.wxsdk.apis.wxpay.config.Configure;
import com.song.wxsdk.apis.wxpay.protocol.mchpay_protocol.MchpayReqData;
import com.song.wxsdk.apis.wxpay.protocol.pay_protocol.JSAPIPayReqData;
import com.song.wxsdk.apis.wxpay.util.HttpsUtil;
import com.song.wxsdk.utils.NetUtil;
import com.song.wxsdk.utils.XMLParser;

import java.util.Map;

/**
 * Created by Song on 2017/6/26.
 * 微信支付SDK
 */
public final class PaySDK {
    /**
     * 统一下单入口
     * @return 成功，则返回预支付订单号prepay_id
     */
    public  String unifiedorder(JSAPIPayReqData xmlObj){
        try{
            String resxmlData = NetUtil.post(Configure.PAY_API,xmlObj.toXmlStr());
            if(null == resxmlData) return null;
            Map<String,Object> mapData = XMLParser.getMapFromXML(resxmlData);
            if(mapData.get("return_code").equals("SUCCESS") && mapData.get("result_code").equals("SUCCESS")){
                return (String)mapData.get("prepay_id");
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * 企业付款api
     * @param xmlObj
     * @return
     */
    public  Map<String,Object> mchPay(MchpayReqData xmlObj){
        Map<String,Object> mapData = null;
        try {
            HttpsUtil httpsUtil = new HttpsUtil();
            String resxmlData =httpsUtil.xmlPost(Configure.MCH_PAY_API,xmlObj.toXmlString());
            if(null == resxmlData) return null;
            mapData = XMLParser.getMapFromXML(resxmlData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mapData;
    }
}
