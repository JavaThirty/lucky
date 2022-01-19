package cn.hzp.award.service.user;

import cn.hzp.award.pojo.User;

/**
 * @author java30
 * @date 2022/1/19
 * @apinote
 */
public interface UserService {
    /**
     * 注册方法
     * @param user 添加user对象
     * @return
     */
    public boolean addUser(User user);

    /**
     * 登录方法
     * @param user 登陆对象
     * @return
     */
    public User login(User user);
}
