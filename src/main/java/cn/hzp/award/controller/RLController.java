package cn.hzp.award.controller;

import cn.hzp.award.pojo.User;
import cn.hzp.award.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录与注册控制层
 * @author java30
 * @date 2022/1/19
 * @apinote
 */
@Controller
public class RLController {
    @Autowired
    UserService userService;
    //注册
    @ResponseBody
    @PostMapping("/register")
    public Map registerUser(User user){
        Boolean b = userService.addUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("flag",b);
        return map;
    }
    //登录
    @ResponseBody
    @PostMapping("/login")
    public Map loginUser(@RequestParam("email") String email,
                         @RequestParam("pwd") String pwd,
                         HttpSession session){
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setEmail(email);
        user.setPassword(pwd);
        User u = userService.login(user);
        if(u!=null){
            session.setAttribute("loginuser",u);
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return map;
    }
}
