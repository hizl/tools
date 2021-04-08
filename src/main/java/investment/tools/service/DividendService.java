package investment.tools.service;

import investment.tools.dto.DividendsDto;

import java.util.List;

public interface DividendService {

    void deleteDividends(Long id);


    List<DividendsDto> findAll();


    DividendsDto findById(Long id);
}
