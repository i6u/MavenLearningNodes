package org.zttc.user.service;

import org.zttc.bean.User;

/**
 * Created by zhouweitao on 16/9/6.
 */
public interface IUserService {
    void add(User user);
    User loadByUsername(String username);
}
