package investment.tools.Hibirnate;

import investment.tools.entity.ContactDetails;
import org.hibernate.Session;

public class BiDirectional {
    public static void main(String[] args) {
    BIDIRECTIONALRELATION();
    }


    public static void BIDIRECTIONALRELATION() {
        HibernateConnector.getSessionFactoryWithContactDetails();


        try {


            Session session = HibernateConnector.getSessionFactoryWithContactDetails().getCurrentSession();
            //create entity

            session.beginTransaction();
            ContactDetails contactDetails = new ContactDetails("BiDirectional",
                    "second_contact");

            session.save(contactDetails);

            session.getTransaction().commit();



        } finally {
            HibernateConnector.closeSessionFactory();



        }


    }


}
