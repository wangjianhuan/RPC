package com.wangjh.provider.api.impl;

import com.wangjh.provider.api.HelloService;

/**
 * @author wjh
 * @date 2022/6/9 12:01 AM
 * @email 1151777592@qq.com
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String userName) {
        return "Hello" + userName;
    }
}
