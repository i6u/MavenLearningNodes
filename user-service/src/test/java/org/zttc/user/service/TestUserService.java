package org.zttc.user.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zttc.bean.User;
import org.zttc.dao.IUserDao;
import org.zttc.user.util.EntitiesHelper;

import static org.easymock.EasyMock.*;

/**
 * Created by zhouweitao on 16/9/6.
 */
public class TestUserService {
    private IUserDao userDao;
    private IUserService userService;
    private User baseUser;

    @Before
    public void setUp() {
        userDao = createStrictMock(IUserDao.class);
        userService = new UserService(userDao);
        baseUser = new User("admin", "123", "admin");
    }

    @Test
    public void testAdd() {
        userDao.add(baseUser);
        expectLastCall();
        replay(userDao);
        userService.add(baseUser);
    }

    @Test
    public void testLoadByUsername() {
        expect(userDao.load("admin")).andReturn(baseUser);
        replay(userDao);
        User tu = userService.loadByUsername("admin");
        EntitiesHelper.assertUser(tu, baseUser);
    }

    @After
    public void tearDown() {
        verify(userDao);

    }
}
