package investment.tools.service;

import investment.tools.dto.DividendsDto;
import investment.tools.entity.Dividends;
import investment.tools.exception.ValidationException;


import java.util.List;

import static java.util.Objects.isNull;

public class DefaultDividendService implements DividendService {

    @Override
    public DividendsDto saveUser(DividendsDto usersDto) {
        return null;
    }

    @Override
    public void deleteDividend(Integer userId) {

    }

    @Override
    public DividendsDto findByCompany(String company) {
        return null;
    }

    @Override
    public List<DividendsDto> findAll() {
        return null;
    }




    private void validateUserDto(DividendsDto dividendsDto) throws ValidationException {
        if (isNull(dividendsDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(dividendsDto.getCurrentCompany()) || dividendsDto.getCurrentPrice().isEmpty()) {
            throw new ValidationException("Current company or current price is empty");
        }
    }





    public Dividends fromUserDtoToUser(DividendsDto dividendsDto) {
        Dividends dividends = new Dividends();
        dividends.setId(dividendsDto.getId());
        dividends.setMy_current_date(dividendsDto.getCurrentDate());
        dividends.setMy_current_company(dividendsDto.getCurrentCompany());
        dividends.setMy_current_price(dividendsDto.getCurrentPrice());
        return dividends;
    }












}
