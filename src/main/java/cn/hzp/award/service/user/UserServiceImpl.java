package cn.hzp.award.service.user;

import cn.hzp.award.mapper.UserMapper;
import cn.hzp.award.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author java30
 * @date 2022/1/19
 * @apinote
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    /**
     * 注册方法
     * @param user 添加user对象
     * @return
     */
    @Override
    public boolean addUser(User user){
        return userMapper.addUser(user)>0;
    }

    /**
     * 登录方法
     * @param user 登陆对象
     * @return
     */
    @Override
    public User login(User user){
        return userMapper.login(user);
    }
}
