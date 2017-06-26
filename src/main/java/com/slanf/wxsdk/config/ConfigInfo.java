package com.slanf.wxsdk.config;


import com.slanf.wxsdk.utils.PropsUtil;

import java.util.Properties;

/**
 * Created by Song on 2016/12/22.
 * 在全局统一缓存配置文件中的值，避免反复读配置文件
 */
public final class ConfigInfo {
    private  static Properties prop;
    //BASE
    public static  String APPID;
    public static  String APPSECRET;
    public static  String TOKEN;
    //wx pay
    public static String KEY;
    public static String MCHID;
    public static String CERT_PATH;

    public static void init(String path){
        prop = PropsUtil.loadProps(path);
        APPID=PropsUtil.getProperty("APPID",prop);
        APPSECRET=PropsUtil.getProperty("APPSECRET",prop);
        TOKEN=PropsUtil.getProperty("TOKEN",prop);

        KEY=PropsUtil.getProperty("KEY",prop);
        MCHID=PropsUtil.getProperty("MCHID",prop);
        CERT_PATH=PropsUtil.getProperty("CERT_PATH",prop);
    }

    public  static void init(){
        init("wechat.properties");
    }
    
}
