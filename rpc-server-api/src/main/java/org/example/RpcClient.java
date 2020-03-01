package org.example;

import java.lang.reflect.Proxy;

/**
 * 客户端RPC代理类
 * <p>
 * 其职责仅仅是获取代理类，反回给客户端使用。
 *
 * @author gewas
 * @version 1.0
 * @date 2020/3/1 13:03
 */
public class RpcClient {

    public <T> T serviceProxy(Class<T> interfaceCls, String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls},
                new RemoteInvocationHandler(host, port));
    }
}
