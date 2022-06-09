package com.wangjh.framework;

import java.io.Serializable;

/**
 * @author wjh
 * @date 2022/6/10 12:14 AM
 * @email 1151777592@qq.com
 */
public class URL implements Serializable {

    private String hostname;
    private Integer port;

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
