package investment.tools.Hibirnate;

import investment.tools.entity.ContactDetails;
import investment.tools.entity.Dividends;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
         sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dividends.class)
                .buildSessionFactory();
        return sessionFactory;
    }



    //obtain sessionFactory with ContactDetail's class
    //this method possibility for the work and delete table with cascade
    public static SessionFactory getSessionFactoryWithContactDetails() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dividends.class)
                .addAnnotatedClass(ContactDetails.class)
                .buildSessionFactory();
        return sessionFactory;
    }


    public static void closeSessionFactory(){
        sessionFactory.close();

    }











}
