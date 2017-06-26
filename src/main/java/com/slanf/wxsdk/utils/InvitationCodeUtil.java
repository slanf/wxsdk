package com.slanf.wxsdk.utils;

import java.util.Random;

/**
 * 邀请码工具类
 * Created by SJF on 2017/3/16.
 */
public class InvitationCodeUtil {

    /*// 邀请码生成器
    public static String getInvitationCode(Long id) {

        String source = "0123456789";
        Random rand = new Random(System.currentTimeMillis());
        char[] code = new char[2 * GlobalInfo.INVITATIONCODE];

        for (int i = 2 * GlobalInfo.INVITATIONCODE - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                code[i] = String.valueOf(id % 10).charAt(0);
                //System.out.println(i + " " + code[i]);
                id = id / 10;
            } else {
                code[i] = source.charAt(rand.nextInt(source.length()-1));
                //System.out.println(i + " " + code[i]);
            }
        }

        return String.valueOf(code);
    }

    // 邀请码解析器
    public static Long getId(String invitationCode) {

        Double id = 0d;
        Integer j = GlobalInfo.INVITATIONCODE;
        char[] code = new char[GlobalInfo.INVITATIONCODE];
        for (int i = 0; i < invitationCode.length(); i++) {
            if (i % 2 == 0) {
                code[i / 2] = invitationCode.charAt(i);
                id += Integer.parseInt(String.valueOf(code[i / 2])) * Math.pow(10, --j);
            }
        }

        return id.longValue();
    }


    // 身份码生成器
    public static String getUserCode(Long id) {

        String source = "abcdefghjkmnpqrstuvwxyz0123456789";
        String source2 = "abcdefghjkmnpqrstuvwxyz";
        Random rand = new Random(System.currentTimeMillis());
        char[] code = new char[8];

        for (int i = 7; i >= 0; i--) {
            if (i == 1 || i == 2 || i == 3 || i == 5 || i == 6) {
                code[i] = String.valueOf(id % 10).charAt(0);
                //System.out.println(i + " " + code[i]);
                id = id / 10;
            }
            else if (i == 4 || i == 7) {
                code[i] = source.charAt(rand.nextInt(source.length()-1));
                //System.out.println(i + " " + code[i]);
            }
            else {
                code[i] = source2.charAt(rand.nextInt(source2.length()-1));
            }
        }

        return String.valueOf(code);
    }*/

    // 身份码生成器
    public static String getUserCode(Long id) {
        String source = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        return (source.charAt(random.nextInt(source.length()-1)) + Long.toString(10000000 + id, 36)).toUpperCase();
    }

    // 邀请码生成器
    public static String getInvitationCode(Long id) {
        String source = "0123456789";
        Random random = new Random();
        return (source.charAt(random.nextInt(source.length()-1)) + Long.toString(10000000 + id, 36)).toUpperCase();
    }

    // 解析器
    public static Long getId(String code) {
        return Long.parseLong(code.substring(1).toLowerCase(), 36) - 10000000;
    }
}
