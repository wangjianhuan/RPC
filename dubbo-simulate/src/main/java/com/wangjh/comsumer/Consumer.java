package com.wangjh.comsumer;

import com.wangjh.framework.Invocation;
import com.wangjh.framework.ProxyFactory;
import com.wangjh.framework.protocol.http.HttpClient;
import com.wangjh.provider.api.HelloService;

/**
 * @author wjh
 * @date 2022/6/9 12:03 AM
 * @email 1151777592@qq.com
 */
public class Consumer {
    public static void main(String[] args) {

        //启动   网络传输   接收请求
        // Tomcat Netty Jetty Socket
        //支持配置  读取配置
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String s = helloService.sayHello("王建欢2");

        System.out.println("result = " + s);


    }
}
