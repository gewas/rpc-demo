package org.example.service;

import org.example.api.IHelloService;

import java.util.Date;

/**
 * RPC服务实现
 *
 * @author gewas
 * @version 1.0
 * @date 2020/3/1 12:59
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public String greeting(String name, Date date) {
        return "Greeting " + name + " at " + date;
    }
}
