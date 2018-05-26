package com.chiyi.common;




import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

/**
 * 工具类
 */
public class ThisSystemUtil {
    public static String EncoderByMd5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5=new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
        }
    }

    public static int parseInt(String target,int defaultValue){
        try {
            return Integer.parseInt(target.trim());
        }catch (Exception e){
            return defaultValue;
        }
    }

    public static String uuid(){
        String uuid = UUID.randomUUID().toString();
        char[] cs = new char[32];
        char c = 0;
        for(int i = uuid.length(),j=0;i-->0;){
            if((c=uuid.charAt(i)) != '-'){
                cs[j++] = c;
            }
        }
        return new String(cs);
    }

    public static String fillMD5(String md5){
        return md5.length()==32?md5:fillMD5("0"+md5);
    }



}
