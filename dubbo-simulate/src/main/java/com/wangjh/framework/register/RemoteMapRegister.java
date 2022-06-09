package com.wangjh.framework.register;

import cn.hutool.core.util.ObjectUtil;
import com.wangjh.framework.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wjh
 * @date 2022/6/10 12:21 AM
 * @email 1151777592@qq.com
 */
public class RemoteMapRegister {

    // 模拟注册中心
    private static Map<String, List<URL>> REGISTER = new HashMap<>();  //list 有可能集群注册  对应多个url

    public static void regist(String interfaceName, URL url){
        List<URL> list = REGISTER.get(interfaceName);
        if (ObjectUtil.isEmpty(list)) {
            list = new ArrayList<>();
        }
        list.add(url);
        REGISTER.put(interfaceName, list);
    }

    public static List<URL> get(String interfaceName) {
        return REGISTER.get(interfaceName);
    }

    private static void saveFile(){

    }
}
