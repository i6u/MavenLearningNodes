package org.zttc.dao;

import org.zttc.bean.User;

/**
 * Created by zhouweitao on 16/9/5.
 *
 */
public interface IUserDao {
    void add(User user);
    User load(String username);
}
