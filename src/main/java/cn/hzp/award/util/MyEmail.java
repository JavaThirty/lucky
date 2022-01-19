package cn.hzp.award.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.time.chrono.MinguoEra;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author java30
 * @date 2022/1/19
 * @apinote
 */
@Component
public class MyEmail {
    private String from;
    @Resource
    JavaMailSender javaMailSender;
    /**
     * 随机生成验证码
     *
     * @return
     */
    public String achieveCode() {
        String[] beforeShuffle = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "G", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(3, 9);
        System.out.println(result);
        return result;
    }

    /**
     * 发送验证码
     * @param email 发送到
     * @param
     */
    public Boolean sendMail(String email, HttpSession session){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("2565790896@qq.com");
        msg.setTo(email);
        msg.setSubject("拼多多盲盒");
        String random = achieveCode();
        session.setAttribute("mailcode",random);
        msg.setText("<font style='color:green'>"+random+"</font>");
        try {
            javaMailSender.send(msg);
        }catch (MailException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
