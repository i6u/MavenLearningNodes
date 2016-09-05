package org.zttc.user.service;

import org.zttc.bean.User;
import org.zttc.dao.IUserDao;

/**
 * Created by zhouweitao on 16/9/6.
 */
public class UserService implements IUserService {
    private IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public User loadByUsername(String username) {
        return userDao.load(username);
    }
}
