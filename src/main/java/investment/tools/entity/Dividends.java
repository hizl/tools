package investment.tools.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "DIVIDENDS")
@Data
@NoArgsConstructor
public class Dividends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String my_current_date;

    @Column
    private String my_current_company;

    @Column
    private String my_current_price;









}
