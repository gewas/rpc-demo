package org.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Socket监听服务包装类
 *
 * @author gewas
 * @version 1.0
 * @date 2020/3/1 13:30
 */
public class RpcProxyServer {

    public void publish(Object service, int port) {
        ExecutorService rpcExecutorPool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                // 使用了BIO
                Socket socket = serverSocket.accept();
                rpcExecutorPool.execute(new RpcRequestProcessor(socket, service));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
