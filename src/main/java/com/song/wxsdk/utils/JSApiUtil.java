package com.song.wxsdk.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Song on 2016/12/22.
 * 用于网页微信接口config参数生成
 */
public class JSApiUtil {

    /**
     * 获得签名
     * @param params 待编码参数，参数值为空不传入
     * @return
     */
    public static String getSign(Map<String,String> params) throws UnsupportedEncodingException{
        List<String> list = new ArrayList<String>(params.keySet());
        Collections.sort(list,new DictionaryCompare());
        StringBuffer sb = new StringBuffer();
        for(String keyVal:list){
            sb.append(keyVal+"="+params.get(keyVal)+"&");
        }
        sb.deleteCharAt(sb.length()-1);
        return DigestUtils.sha1Hex(sb.toString());
    }

    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getNonceStr(int length) {
        String base = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
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

    public static void main(String [] args) throws UnsupportedEncodingException{
        Map<String,String> params = new HashMap<String, String>();
        params.put("noncestr","Wm3WZYTPz0wzccnW");
        params.put("jsapi_ticket","sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg");
        params.put("timestamp","1414587457");
        params.put("url","http://mp.weixin.qq.com?params=value");
        System.out.println("NonceStr: "+getNonceStr(32));
        System.out.println("Sign: "+getSign(params));
    }

}

