package cn.hzp.award.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author java30
 * @date 2022/1/11
 * @apinote
 */
@Controller
public class ToController {

    @GetMapping("/register")
    public String toZhuce(){
        return "register";
    }

    @GetMapping("/login")
    public String towelcom(Model model){
        return "login";
    }

}
