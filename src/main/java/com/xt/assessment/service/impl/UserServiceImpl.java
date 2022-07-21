package com.xt.assessment.service.impl;

import com.xt.assessment.dao.UserDao;
import com.xt.assessment.entity.User;
import com.xt.assessment.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Xiaotian
 * @Email : xilong@deloitte.com.cn
 * @Date: 2022/5/23
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> queryUser() {
        return userDao.queryUser();
    }

    @Override
    public User queryUserById(String id) {
        return userDao.queryUserById(id);
    }

    @Override
    public User queryUserByEmail(String email) {
        if (email != null && !"".equals(email)) {
            return userDao.queryUserByEmail(email);
        } else {
            return null;
        }
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertUser(User user) {
        if (user != null && !"".equals(user.getId())) {
            try {
                int i = userDao.insertUser(user);
                if (i == 1) {
                    return true;
                } else {
                    throw new RuntimeException("a:插入用户失败！" + user);
                }
            } catch (Exception e) {
                throw new RuntimeException("b:插入用户失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("c:插入用户失败，用户id不能为空！");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUser(User user) {
        if (user != null && !"".equals(user.getId())) {
            try {
                int i = userDao.updateUser(user);
                if (i == 1) {
                    return true;
                } else {
                    throw new RuntimeException("a:用户更新失败！" + user);
                }
            } catch (Exception e) {
                throw new RuntimeException("b:用户更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("c:用户更新失败，用户id不能为空！");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUser(String id) {
        if (id != null && !"".equals(id)) {
            try {
                int i = userDao.deleteUser(id);
                if (i == 1) {
                    return true;
                } else {
                    throw new RuntimeException("a:删除用户失败！" + id);
                }
            } catch (Exception e) {
                throw new RuntimeException("b:删除用户失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("c:删除用户失败，用户id不能为空！");
        }
    }
}
