package investment.tools.service;


import investment.tools.dto.DividendsDto;
import investment.tools.entity.exampleOneToOne.Dividends;
import org.springframework.stereotype.Component;


@Component
public class DividendsConverter {



   public Dividends fromDividendsDtoToUser(DividendsDto dividendsDto) {
        Dividends dividends = new Dividends();
        dividends.setId(dividendsDto.getId());
        dividends.setMy_current_date(dividendsDto.getCurrentDate());
        dividends.setMy_current_company(dividendsDto.getCurrentCompany());
        dividends.setMy_current_price(dividendsDto.getCurrentPrice());
        return dividends;
    }


    public DividendsDto fromDividendsDtoToUserDto(Dividends dividends) {
        return DividendsDto.builder().id(dividends.getId())
                .currentDate(dividends.getMy_current_date())
                .currentCompany(dividends.getMy_current_company())
                .currentPrice(dividends.getMy_current_price())
                .build();
    }


    public DividendsDto FFF(Dividends dividends) {
        return DividendsDto.builder()
                .id(dividends.getId())
                .currentDate(dividends.getMy_current_date())
                .currentCompany(dividends.getMy_current_company())
                .currentPrice(dividends.getMy_current_price())
                .build();
    }


}
