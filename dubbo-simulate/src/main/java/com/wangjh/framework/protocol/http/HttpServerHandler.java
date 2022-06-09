package com.wangjh.framework.protocol.http;

import com.wangjh.framework.Invocation;
import com.wangjh.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wjh
 * @date 2022/6/9 12:43 AM
 * @email 1151777592@qq.com
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        //处理请求逻辑
        try {
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();

            String interfaceName = invocation.getInterfaceName();

            Class aClass = LocalRegister.get(interfaceName);

            Method method = aClass.getMethod(invocation.getMethodName(), invocation.getParaTypes());

            String o = (String) method.invoke(aClass.newInstance(), invocation.getParams());

            IOUtils.write(o,resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
