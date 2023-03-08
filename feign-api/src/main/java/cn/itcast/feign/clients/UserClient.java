package cn.itcast.feign.clients;

import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: UserClient
 * @Author: le
 * @Date: 2023/3/8 18:33
 **/
@FeignClient("userservice")
public interface UserClient {
    @GetMapping("/user/{id}")
    User findByid (@PathVariable("id") Long id);
}
