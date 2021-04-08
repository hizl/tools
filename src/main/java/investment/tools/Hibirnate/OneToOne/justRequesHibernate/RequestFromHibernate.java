package investment.tools.Hibirnate.OneToOne.justRequesHibernate;

import investment.tools.Hibirnate.OneToOne.HibernateConnector;
import investment.tools.entity.exampleOneToOne.Dividends;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RequestFromHibernate {
    private static HibernateConnector hibernateConnector;

    public static void main(String[] args) {
        updateDividendsFieldByIDHardcoded();
    }


    //add new Dividends
    public static void addDividends() {
        hibernateConnector.getSessionFactory();
        try {

            Session session = hibernateConnector.getSessionFactory().getCurrentSession();

            Dividends dividends = new Dividends("05.01.2005", "Q1111QQ", 133);
            session.beginTransaction();
            session.save(dividends);
            session.getTransaction().commit();
        } finally {
            hibernateConnector.closeSessionFactory();
        }
    }


    public static void updateDividendsFieldByIDHardcoded() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dividends.class)
                .buildSessionFactory();
        try {


            Session session = sessionFactory.openSession();
            session.beginTransaction();


            //change by id
               /* Dividends dividends = session.get(Dividends.class,2);
                dividends.setMy_current_company("GAZ_FACTORY");
                session.save(dividends);*/


            session.createQuery("update Dividends set my_current_company = 'GAZ' where my_current_date  = '05.05.2005'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }


    //use HQL java class Dividends
    public static void getAllDividends() {

        hibernateConnector.getSessionFactory();


        try {


            Session session = hibernateConnector.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            List<Dividends> dividendsList = session.createQuery("from Dividends where my_current_price = 2500 ").getResultList();


            for (Dividends o : dividendsList) {
                System.out.println(o);
            }

            session.getTransaction().commit();

        } finally {
            hibernateConnector.closeSessionFactory();
        }


    }


}
