package cn.hzp.award.util;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${spirng.mail.username}")
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
     * @param session
     */
    public void sendMail(String email, HttpSession session){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            //设置发件人
            mimeMessageHelper.setFrom(from);
            //设置收件人
            mimeMessageHelper.setTo(email);
            //设置邮件主题
            mimeMessageHelper.setSubject("拼多多抽奖");
            //生成验证码
            String random = achieveCode();
            //将验证码放到session中
            session.setAttribute("email",email);
            session.setAttribute("code",random);
            //设置验证码样式
            mimeMessageHelper.setText("<font style='color:green'>"+random+"</font>",true);
            javaMailSender.send(mimeMessage);
        }catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
