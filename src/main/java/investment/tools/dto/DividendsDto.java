package investment.tools.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DividendsDto {

    private Integer id;
    private String currentDate;
    private String currentCompany;
    private Integer currentPrice;


}