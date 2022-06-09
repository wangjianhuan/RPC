package com.wangjh.framework;

import com.wangjh.framework.protocol.http.HttpClient;
import com.wangjh.framework.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

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
                //mock功能
                String mock = System.getProperty("mock");
                if (mock != null && mock.startsWith("return:")) {
                    String result = mock.replace("return:", "");
                    return result;
                }

                //重试机制 dubbo默认重试2次  最多请求三次
                int i = 2;
                while (true) {
                    try {
                        HttpClient httpClient = new HttpClient();
                        Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);

                        //此刻的地址为固定的   引入注册中心的概念
                        //从注册中心拿到所有注册的服务
                        List<URL> list = RemoteMapRegister.get(interfaceClass.getName());  // TODO: 2022/6/10  项目报错list为空  是因为Provider和Consumer为两个不同的进程  无法相互访问  （暂未实现）  此处注册中心应该为REDIS NACOS等单独的服务  方便消费者于提供者共享

                        //这里为负载均衡(只实现随机获取一个IP)
                        URL url = LoadBalance.random(list);

                        String result = httpClient.send(url.getHostname(), url.getPort(), invocation);
                        return result;
                    } catch (Exception e) {
                        if (i-- > 0)
                            continue;
                        //读取用户的配置 或者Class+方法名
                        return "报错了";
                    }
                }
            }
        });
    }
}
