package investment.tools.TEST;

import investment.tools.entity.Dividends;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMain {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dividends.class)
                .buildSessionFactory();


        try {


            Session session = sessionFactory.getCurrentSession();


            Dividends dividends = new Dividends( "05.01.2005", "QQQ", "111");
            session.beginTransaction();
            session.save(dividends);
            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
