package investment.tools.service;

import investment.tools.dto.DividendsDto;
import investment.tools.entity.Dividends;

import java.util.List;

public interface DividendService {

    void deleteDividends(Integer id);


    List<DividendsDto> findAll();

}
