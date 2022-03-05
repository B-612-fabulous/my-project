package com.zj.config.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 *  * 采用MD5加密解密
 * @Title: MD5Util.java
 * @Description: 
 * @author jacky
 * @date 2019年5月8日 下午9:59:34
 */
public class MD5Util{

    static Logger logger = LoggerFactory.getLogger(MD5Util.class);

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch(Exception e){
            logger.error("加密出错===>" + e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for(int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for(int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if(val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){
        char[] a = inStr.toCharArray();
        for(int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    // 测试主函数
    public static void main(String args[]){
        String s = new String("1");
//        logger.info("原始密码===>" + s);
//        logger.info("原始密码===>" + string2MD5(s));
//        logger.info("加密的：===>" + convertMD5(s));
//        logger.info("解密的： ===>" + convertMD5(convertMD5(s)));

    }
}
