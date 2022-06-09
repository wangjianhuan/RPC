package com.wangjh.provider;

import com.wangjh.framework.protocol.http.HttpServer;
import com.wangjh.framework.register.LocalRegister;
import com.wangjh.provider.api.HelloService;
import com.wangjh.provider.api.impl.HelloServiceImpl;

/**
 * @author wjh
 * @date 2022/6/9 12:00 AM
 * @email 1151777592@qq.com
 */
public class Provider {
    public static void main(String[] args) {

        //启动   网络传输   接收请求
        // Tomcat Netty Jetty Socket
        //支持配置  读取配置

        //支持可以配置多个实现类
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);
    }
}
