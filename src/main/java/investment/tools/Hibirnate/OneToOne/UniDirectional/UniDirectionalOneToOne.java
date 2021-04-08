package investment.tools.Hibirnate.OneToOne.UniDirectional;

import investment.tools.Hibirnate.OneToOne.HibernateConnector;
import investment.tools.entity.exampleOneToOne.ContactDetails;
import investment.tools.entity.exampleOneToOne.Dividends;
import org.hibernate.Session;



// this UniDirectional execute cascade some object and execute other object as part of this object

public class UniDirectionalOneToOne {
    public static void main(String[] args) {
        getDividendsAndDetails();

    }


    public static void addUniDirectional(){
        //using util class HibernateConnector and her methods
        HibernateConnector.getSessionFactoryWithContactDetails();
        try {
            //open session through getCurrentSession();
            Session session = HibernateConnector.getSessionFactoryWithContactDetails().getCurrentSession();
            //create object
            Dividends dividends =
                    new Dividends("01.02.1900","FORD",4_000_000);

            ContactDetails contactDetails =
                    new ContactDetails("Just","Ford");
            //add details
            dividends.setContactDetails(contactDetails);

            //begin
            session.beginTransaction();

            //save
            session.save(dividends);

            //get transaction and commit
            session.getTransaction().commit();
        }
        finally {
            //finally close session factory
            HibernateConnector.closeSessionFactory();
        }
    }



    public static void getDividendsAndDetails(){
        HibernateConnector.getSessionFactoryWithContactDetails();

        Session session = null;
        try {
            //get current session
            session = HibernateConnector.getSessionFactoryWithContactDetails().getCurrentSession();
            //begin transaction
            session.beginTransaction();
            //create object
            Dividends dividends = session.get(Dividends.class,6);
            //System.out.println(dividends);


            //get transaction commit and close
            session.getTransaction().commit();
        }
        finally {

            // if don't work    session.getTransaction().commit();   ,  then need execute session.close()
            //session.close();
            HibernateConnector.closeSessionFactory();
        }
    }


    public static void deleteDividendsAndDetailsCascade(){
        HibernateConnector.getSessionFactoryWithContactDetails();

        Session session = null;



        try {
            session = HibernateConnector.getSessionFactoryWithContactDetails().getCurrentSession();

            session.beginTransaction();

            Dividends dividends = session.get(Dividends.class,6);


            session.delete(dividends);
            session.getTransaction().commit();
        }
        finally {
            HibernateConnector.closeSessionFactory();
        }


    }




}
