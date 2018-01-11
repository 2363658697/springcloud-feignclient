package cn.et;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("SENDMAIL") //被调用的服务的服务名
public interface SendEmail {

    //被调用的服务中的方法
    @PostMapping("/psend")
    public String sendMail(@RequestBody Map<String,Object> map);
   
}
