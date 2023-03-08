package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2利用RestTemplate发起http请求
//        String url = "http://userservice/user/"+order.getUserId();
        //利用RestTemplate发送get请求
//        User user = restTemplate.getForObject(url, User.class);

//        利用feign远程调用
        User user = userClient.findByid(order.getUserId());

        //封装User
        order.setUser(user);

        // 4.返回
        return order;
    }


}
