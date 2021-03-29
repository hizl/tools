package investment.tools.service;

import investment.tools.dto.DividendsDto;
import investment.tools.entity.Dividends;
import investment.tools.exception.ValidationException;
import investment.tools.repository.DividendRepository;
import lombok.AllArgsConstructor;


import java.util.List;

import static java.util.Objects.isNull;


@AllArgsConstructor
public class DefaultDividendService implements DividendService {

    private final DividendRepository dividendRepository;
    private final DividendsConverter usersConverter;






/*  constructor inject it into the controller. Im use annotation @AllArgsConstructor in this class

    public DefaultDividendService(DividendRepository dividendRepository, DividendsConverter usersConverter) {
        this.dividendRepository = dividendRepository;
        this.usersConverter = usersConverter;
    }*/



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
            throw new ValidationException("Object is null");
        }
        if (isNull(dividendsDto.getCurrentCompany()) || dividendsDto.getCurrentPrice().isEmpty()) {
            throw new ValidationException("Current company or current price is empty");
        }
    }














}
