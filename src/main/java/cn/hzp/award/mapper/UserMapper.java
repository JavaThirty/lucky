package cn.hzp.award.mapper;

import cn.hzp.award.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author java30
 * @date 2022/1/19
 * @apinote
 */
@Mapper
public interface UserMapper {
    /**
     * 注册方法
     * @param user 添加user对象
     * @return
     */
    public int addUser(User user);

    /**
     * 登录方法
     * @param user 登陆对象
     * @return
     */
    public User login(User user);
}
