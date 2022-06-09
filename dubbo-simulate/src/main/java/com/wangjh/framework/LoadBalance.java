package com.wangjh.framework;

import java.util.List;
import java.util.Random;

/**
 * @author wjh
 * @date 2022/6/10 12:57 AM
 * @email 1151777592@qq.com
 * 负载均衡算法
 */
public class LoadBalance {

    //随机获取一个可用list
    public static URL random(List<URL> list) {
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
