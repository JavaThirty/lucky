package cn.hzp.award.controller;


import cn.hzp.award.util.MyEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author java30
 * @date 2022/1/19
 * @apinote
 */
@Controller
public class ItripAuthController {
    @Autowired
    MyEmail myEmaill;
    //发送验证码
    @ResponseBody
    @GetMapping("/sendcode")
    public Map sendEmailCode(HttpSession session) {
        //@RequestParam("email") String email,
        //HttpSession session
        Map<String,Object> map = new HashMap<>();
        if(myEmaill.sendMail("43103113@qq.com",session)){
            map.put("msg","success");
        }else{
            map.put("msg","defeated");
        }

        return map;
    }

}
