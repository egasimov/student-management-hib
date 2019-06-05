package MainPackage;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HiberUtil {
    private static  SessionFactory sessionFactory;

    private HiberUtil(){};

    static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
        try {
            Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
            sessionFactory = config.buildSessionFactory();
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        return sessionFactory;
    }

    static void closeSessionFactory(){
        if(sessionFactory.isOpen()){
            sessionFactory.close();
        }
    }

}
