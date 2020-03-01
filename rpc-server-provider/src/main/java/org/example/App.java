package org.example;

import org.example.service.HelloServiceImpl;

/**
 * RPC服务器
 * <p>
 * 启动后只需要构建服务器，发布服务监听即可。
 */
public class App {
    public static void main(String[] args) {
        RpcProxyServer server = new RpcProxyServer();
        server.publish(new HelloServiceImpl(), 8081);
    }
}
