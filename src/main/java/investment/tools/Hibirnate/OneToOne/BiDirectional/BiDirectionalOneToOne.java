package investment.tools.Hibirnate.OneToOne.BiDirectional;

import investment.tools.Hibirnate.OneToOne.HibernateConnector;
import investment.tools.entity.exampleOneToOne.ContactDetails;
import investment.tools.entity.exampleOneToOne.Dividends;
import org.hibernate.Session;

public class BiDirectionalOneToOne {
    public static void main(String[] args) {
        bidirectionalrelationAddNewDividendsAndContact();
    }


    public static void bidirectionalrelationAddNewDividendsAndContact() {
        HibernateConnector.getSessionFactoryWithContactDetails();


        try {


            Session session = HibernateConnector.getSessionFactoryWithContactDetails().getCurrentSession();
            //начало транзакции
            session.beginTransaction();


            //save
            Dividends dividends = new Dividends("01.07.2009","Sberbank",16_000_000);

            ContactDetails contactDetails = new ContactDetails("Vladimir","Petrov");

            dividends.setContactDetails(contactDetails);
            contactDetails.setDividends(dividends);

            session.save(dividends);
            session.save(contactDetails);


        /*    //delete dividends and contactDetails
            Dividends deleteDividends = session.get(Dividends.class, 3);
            ContactDetails deleteContactDetails = session.get(ContactDetails.class, 1);


            deleteDividends.getContactDetails().setDividends(null);

            session.delete(deleteDividends);
            // session.delete(deleteContactDetails);
*/

            session.getTransaction().commit();


        } finally {
            HibernateConnector.closeSessionFactory();


        }


    }


}
