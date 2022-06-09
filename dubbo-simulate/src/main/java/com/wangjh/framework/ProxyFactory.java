package com.wangjh.framework;

import com.wangjh.framework.protocol.http.HttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wjh
 * @date 2022/6/9 10:24 PM
 * @email 1151777592@qq.com
 */
public class ProxyFactory<T> {
    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                String result = httpClient.send("localhost", 8080, invocation);
                return result;
            }
        });
    }
}
