package org.example;

import org.example.api.IHelloService;

import java.time.Instant;
import java.util.Date;

/**
 * 客户端通过代理类调用方法
 * <p>
 * RPC的实现对客户端透明。
 */
public class App {
    public static void main(String[] args) {
        RpcClient rpcClient = new RpcClient();
        IHelloService service = rpcClient.serviceProxy(IHelloService.class, "localhost", 18081);
        System.out.println(service.greeting("gewas", Date.from(Instant.now())));
    }
}
