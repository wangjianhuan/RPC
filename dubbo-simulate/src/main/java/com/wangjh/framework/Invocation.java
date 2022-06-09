package com.wangjh.framework;

import java.io.Serializable;

/**
 * @author wjh
 * @date 2022/6/9 12:59 AM
 * @email 1151777592@qq.com
 */
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Class[] paraTypes;
    private Object[] params;

    public Invocation() {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paraTypes = paraTypes;
        this.params = params;
    }

    public Invocation(String interfaceName, String methodName, Class[] paraTypes, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paraTypes = paraTypes;
        this.params = params;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParaTypes() {
        return paraTypes;
    }

    public void setParaTypes(Class[] paraTypes) {
        this.paraTypes = paraTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
