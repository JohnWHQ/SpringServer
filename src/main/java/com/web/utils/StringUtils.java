package com.web.utils;

import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * 字符串规则生成工具类
 */
public class StringUtils {

    /**
     * Token生成器
     * @param openId 开放ID
     * @param sessionKey Session标识
     * @return 生成的系统Token字符串
     */
    public static String generateToken(String openId, String sessionKey) {
        Random random = new Random();
        String key = openId + sessionKey;
        char[] keyArr = key.toCharArray();
        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(keyArr.length);
            int b = random.nextInt(keyArr.length);
            char c = keyArr[a];
            keyArr[a] = keyArr[b];
            keyArr[b] = c;
        }
        return DigestUtils.md5DigestAsHex((new String(keyArr)).getBytes());
    }

}
