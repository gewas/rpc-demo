package org.example;

import java.io.Serializable;
import java.util.Arrays;

/**
 * RPC通用请求类
 * <p>
 * 包含RPC调用信息：类名，方法名，方法参数类型，参数
 *
 * @author gewas
 * @version 1.0
 * @date 2020/3/1 13:12
 */
public class RpcRequest implements Serializable {

    private String classname;
    private String method;
    private Class<?>[] types;
    private Object[] params;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Class<?>[] getTypes() {
        return types;
    }

    public void setTypes(Class<?>[] types) {
        this.types = types;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "classname='" + classname + '\'' +
                ", method='" + method + '\'' +
                ", types=" + Arrays.toString(types) +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
