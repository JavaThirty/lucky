package cn.hzp.award.pojo;

import lombok.Data;

/**
 * @author java30
 * @date 2022/1/19
 * @apinote
 */
@Data
public class User {
    private Integer id;//序列id
    private String email;//邮箱
    private String password;//密码 8-16
    private Integer inviteid;//上级id
    private String photo;//个人头像
    private int integral;//积分
    private String introduce;//个人介绍
    private String invitecode;//邀请码
    private String name;//昵称
}
