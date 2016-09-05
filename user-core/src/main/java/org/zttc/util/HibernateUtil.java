package org.zttc.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * hibernate 4.1.10.Final会导致自定义createQuery卡死
 * 更换hibernate 5.1.10.Final问题解决
 */
//import static com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.FACTORY;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by zhouweitao on 16/9/5.
 */
public class HibernateUtil {
    //private final static SessionFactory FACTORY = buildSessionFactory();
    private final static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        //Configuration cfg = new Configuration().configure();
        //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        //SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
        //return factory;

        // 注册服务
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        // 创建会话工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void close(Session session) {
        if (session != null) session.close();
    }
}
