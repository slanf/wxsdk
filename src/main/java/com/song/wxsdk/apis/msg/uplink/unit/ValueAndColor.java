package com.song.wxsdk.apis.msg.uplink.unit;

/**
 * Created by Song on 2017/6/26.
 * 模板消息，值与颜色对
 */
public class ValueAndColor {
    private String value;
    private String color;

    public ValueAndColor(String value) {
        this(value,"#173177");
    }

    public ValueAndColor(String value, String color) {
        this.value = value;
        this.color = color;
    }
}
