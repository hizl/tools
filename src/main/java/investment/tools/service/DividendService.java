package investment.tools.service;

import investment.tools.dto.DividendsDto;

import java.util.List;

public interface DividendService {

    DividendsDto saveUser(DividendsDto usersDto);

    void deleteDividend(Integer userId);

    DividendsDto findByCompany(String company);

    List<DividendsDto> findAll();
}
