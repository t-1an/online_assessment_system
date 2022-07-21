package com.xt.assessment.dao;

import com.xt.assessment.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */

@Repository
public interface UserDao {
    /**
     * 查询所有User，返回List<User>
     *
     * @return 用户列表
     */
    List<User> queryUser();

    /**
     * 根据id查询User，返回User
     *
     * @param id 用户ID
     * @return 用户
     */
    User queryUserById(String id);

    /**
     * 插入一个User对象到数据库中
     *
     * @param user 用户
     * @return msg
     */
    int insertUser(User user);

    /**
     * 更新user，根据id更新
     *
     * @param user 用户
     * @return msg
     */
    int updateUser(User user);

    /**
     * 根据id删除User对象
     *
     * @param id 用户ID
     * @return msg
     */
    int deleteUser(String id);

    /**
     * 根据email查询User，返回User
     *
     * @param email 邮箱
     * @return 用户
     */
    User queryUserByEmail(String email);

}
