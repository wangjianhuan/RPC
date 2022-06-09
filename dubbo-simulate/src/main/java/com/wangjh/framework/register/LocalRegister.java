package com.wangjh.framework.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wjh
 * @date 2022/6/9 4:38 PM
 * @email 1151777592@qq.com
 * 本地注册
 */
public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void regist(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }

}
