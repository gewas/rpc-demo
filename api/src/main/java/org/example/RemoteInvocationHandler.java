package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * RPC代理执行器
 * <p>
 * 利用Java的动态代理，在此处构建RPC请求并发送。
 *
 * @author gewas
 * @version 1.0
 * @date 2020/3/1 13:05
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1、构建rpc请求
        RpcRequest request = new RpcRequest();
        request.setClassname(method.getDeclaringClass().getName());
        request.setMethod(method.getName());
        request.setTypes(method.getParameterTypes());
        request.setParams(args);
        // 2、发起远程调用
        RpcNetTransport netTransport = new RpcNetTransport(host, port);
        return netTransport.send(request);
    }
}
