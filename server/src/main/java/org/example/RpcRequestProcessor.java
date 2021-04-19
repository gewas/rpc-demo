package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 处理RPC请求的处理器线程
 *
 * @author gewas
 * @version 1.0
 * @date 2020/3/1 13:18
 */
public class RpcRequestProcessor implements Runnable {
    private Socket socket;
    private Object service;

    public RpcRequestProcessor(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {

            RpcRequest request = (RpcRequest) inputStream.readObject();
            Object result = invoke(request);

            outputStream.writeObject(result);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName(request.getClassname());
        Method method = clazz.getMethod(request.getMethod(), request.getTypes());
        return method.invoke(service, request.getParams());
    }
}
