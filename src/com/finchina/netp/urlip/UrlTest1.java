package com.finchina.netp.urlip;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest1 {
    public static void main(String [] args) throws MalformedURLException {
        URL url = new URL("https://i.cnblogs.com/EditPosts.aspx?opt=1");
        System.out.println("URL的资源名："+url.getFile());
        System.out.println("主机名："+url.getHost());
        System.out.println("路径部分："+url.getPath());
        System.out.println("端口号："+ url.getPort());
        System.out.println("协议："+url.getProtocol());
        System.out.println("查询条件："+url.getQuery());
    }
}
