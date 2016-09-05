package org.zttc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.zttc.bean.User;
import org.zttc.util.HibernateUtil;

/**
 * Created by zhouweitao on 16/9/5.
 *
 */
public class UserDao implements IUserDao {
    @Override
    public void add(User user) {
        Session session = HibernateUtil.openSession();
        try {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close(session);
        }

    }

    @Override
    public User load(String username) {
        User user = null;
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            user = (User) session.createQuery("from User u where u.username=?").setParameter(0, username).uniqueResult();
        } finally {
            HibernateUtil.close(session);
        }
        return user;
    }
}
