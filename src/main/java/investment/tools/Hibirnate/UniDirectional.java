package investment.tools.Hibirnate;

import investment.tools.entity.ContactDetails;
import investment.tools.entity.Dividends;
import org.hibernate.Session;

public class UniDirectional {

    public static void main(String[] args) {
        getUniDirectional();
    }


    public static void getUniDirectional(){

        //using util class HibernateConnector and her methods
        HibernateConnector.getSessionFactoryWithContactDetails();



        try {

            //open session through getCurrentSession();
            Session session = HibernateConnector.getSessionFactoryWithContactDetails().getCurrentSession();

            //create object
            Dividends dividends =
                    new Dividends("01.02.1900","FORD",4_000_000);

            ContactDetails contactDetails =
                    new ContactDetails("Henry","Ford");


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



}
