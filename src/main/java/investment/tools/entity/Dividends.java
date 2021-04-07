package investment.tools.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import lombok.AllArgsConstructor;



@Entity
@Table(name = "DIVIDENDS")
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class Dividends {

    //описание связи
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    //
    private ContactDetails contactDetails;





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "my_current_date")
    private String my_current_date;

    @Column(name = "my_current_company")
    private String my_current_company;

    @Column(name = "my_current_price")
    private Integer my_current_price;




    public Dividends(String my_current_date, String my_current_company, Integer my_current_price) {
        this.my_current_date = my_current_date;
        this.my_current_company = my_current_company;
        this.my_current_price = my_current_price;
    }
}
