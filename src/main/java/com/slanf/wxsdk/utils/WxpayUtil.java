package com.slanf.wxsdk.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Song on 2016/11/8.
 * mail: 1147649695@qq.com
 * 微信支付相关工具类
 */
public class WxpayUtil {
    /**
     * 获得签名
     * @param params 待编码参数，参数值为空不传入
     * @param key key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     * @return
     */
    public static String getSign(Map<String,Object> params,String key){
        List<String> list = new ArrayList<String>(params.keySet());
        Collections.sort(list,new DictionaryCompare());
        StringBuffer sb = new StringBuffer();
        for(String keyVal:list){
            sb.append(keyVal+"="+params.get(keyVal)+"&");
        }
        sb.append("key="+key);
        System.out.println(sb);
        return DigestUtils.md5Hex(sb.toString()).toUpperCase();
    }

    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取订单号
     * 商户订单号（每个订单号必须唯一）
     * 组成：商户系统内部订单号，要求32个字符内、且在同一个商户号下唯一
     * @return
     */
    public static String getOutTradeNo(){
        Random random = new Random();
        //按要求，日期格式化输出
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer sb = new StringBuffer(df.format(new Date()));
        sb.append(getRandomStringByLength(18));
        return sb.toString();
    }

    /**
     * 将字符串str按长度在前面添0补齐
     * @param str
     * @param length
     * @return
     */
    private static String format(String str,int length){
        String pre = "0000000000";
        int len = str.length();
        if(10<=len) return str.substring(0,10);
        else return pre.substring(0,10-len).concat(str);
    }
}

/**
 * 按字典序排序
 */
class DictionaryCompare implements Comparator<String>{
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
