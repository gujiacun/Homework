//需求：在本包的三个类中，若在网页上输入中文会报错，探讨Cookie的中文问题

package com._520it._03_cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodingDemo {
    public static void main(String[] args) throws Exception {

        // 编码
        String string = "悲しみの先に続く僕たちの未来";
        String ret = URLEncoder.encode(string, "UTF-8");
        System.out.println(ret);
        // 解码
        string = URLDecoder.decode(ret, "UTF-8");
        System.out.println(string);
        // 修改Cookie
        // 方式1: 创建一个name字样的cookie
        // Cookie cookie = new Cookie(“username”, “xiaofei”);
        
        // 方式2：调用cookie setValue(String value) 方法更改
        // cookie.setValue(“xiaofei”);

    }
/**
 * 小结：编码和解码对各国语言文字通用
 */
}
