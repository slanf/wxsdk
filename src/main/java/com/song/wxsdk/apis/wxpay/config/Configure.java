package com.song.wxsdk.apis.wxpay.config;

import com.song.wxsdk.config.ConfigInfo;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class Configure {
//这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改

	//shouluoquanqiu
	private static String key = ConfigInfo.KEY;
	private static String mchID = ConfigInfo.MCHID;
	//canmou
/*	private static String key = "8d872a586f6e2798d55d7c86cadb7d3a";
	private static String mchID = "1404528602";*/
	//微信分配的公众号ID（开通公众号之后可以获取到）
	private static String appID = ConfigInfo.APPID;

	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）

    public static String NOTIFY_API = "";
    //企业付款证书
    public static String CERT_PATH = ConfigInfo.CERT_PATH;
    //企业付款api
    public static String MCH_PAY_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	//以下是几个API的路径：
	//1）统一支付api
	public static String PAY_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	//2）被扫支付查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	//3）退款API
	public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	//4）退款查询API
	public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

	//5）撤销API
	public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	//6）下载对账单API
	public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

	//7) 统计上报API
	public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";


	public static void setKey(String key) {
		Configure.key = key;
	}

	public static void setAppID(String appID) {
		Configure.appID = appID;
	}

	public static void setMchID(String mchID) {
		Configure.mchID = mchID;
	}

	public static String getKey(){
		return key;
	}
	
	public static String getAppid(){
		return appID;
	}
	
	public static String getMchid(){
		return mchID;
	}

}
