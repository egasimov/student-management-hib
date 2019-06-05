package MainPackage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.criteria.*;

import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Iterator;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory=HiberUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
//
//        Student s1=new Student(1,"AAA","A");
//        Student s2=new Student(2,"BBB","B");
//        Student s3=new Student(3,"CCC","C");


        try{
            Transaction tx=session.beginTransaction();
            //to do some work

            //work with criteria

            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {

            if(session.isOpen()){
                session.close();
                System.out.println("Session is closing .. ");
            }
            if(sessionFactory.isOpen()){
                HiberUtil.closeSessionFactory();
                System.out.println("Session Factory is closing");
            }

        }
        System.out.println("PROGRAM COMPLETED");
    }
}
