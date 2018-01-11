package cn.et;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SendController {

    @Autowired
    private SendEmail sendEmail;
    
    //测试负载均衡
    /*@Autowired  
    private LoadBalancerClient loadBalancer;  
  
    @RequestMapping("/choosePub")  
    public String choosePub() {  
        StringBuffer sb=new StringBuffer();  
        for(int i=0;i<=10;i++) {  
            ServiceInstance ss=loadBalancer.choose("SENDMAIL");//从两个sendmail中选择一个 这里涉及到选择算法  
            sb.append(ss.getUri().toString()+"<br/>");  
        }  
        return sb.toString();  
    }  */
    

    @PostMapping("/mail")
    public String sendMail(String send_to,String send_subject,String send_content){
        
        String results =null;
        
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("send_to", send_to);
            map.put("send_subject", send_subject);
            map.put("send_content", send_content);
             results = sendEmail.sendMail(map);
        } catch (Exception e) {
            return "发送失败";
        }
        return results;        
    }
    
}
