package org.example.api;

import java.util.Date;

/**
 * RPC服务接口定义
 *
 * @author gewas
 * @version 1.0
 * @date 2020/3/1 12:54
 */
public interface IHelloService {
    String greeting(String name, Date date);
}
