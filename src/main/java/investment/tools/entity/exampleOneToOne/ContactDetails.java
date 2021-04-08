package investment.tools.entity.exampleOneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class ContactDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private int id_contact;

    @Column(name = "name_contact")
    private String name_contact;


    @Column(name = "surname_contact")
    private String surname_contact;


    public ContactDetails(String name_contact, String surname_contact) {
        this.name_contact = name_contact;
        this.surname_contact = surname_contact;
    }



    /*


    bellow code mean this it:
    i adding class "Dividends-class" from one-two-one BI Directional.
    */


    @OneToOne(mappedBy = "contactDetails",cascade = CascadeType.ALL)
    Dividends dividends;

}
