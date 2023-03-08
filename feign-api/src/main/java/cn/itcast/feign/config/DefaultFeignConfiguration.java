package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: DefaultFeignConfiguration
 * @Author: le
 * @Date: 2023/3/8 18:50
 **/
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
}
