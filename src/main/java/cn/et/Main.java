package cn.et;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients  //开启feign客户端
@SpringBootApplication 
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
