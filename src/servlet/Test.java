package servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author hhy
 * @Date 2019/8/9 10:35
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="美女";
        System.out.println(str);
        String encode= URLEncoder.encode(str,"utf-8");
        System.out.println(encode);
        String decode= URLDecoder.decode(encode,"utf-8");
        System.out.println(decode);
    }
}
