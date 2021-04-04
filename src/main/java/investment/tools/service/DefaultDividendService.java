package investment.tools.service;


import investment.tools.dto.DividendsDto;
import investment.tools.entity.Dividends;
import investment.tools.exception.ValidationException;
import investment.tools.repository.DividendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class DefaultDividendService implements DividendService {

    private final DividendsRepository dividendsRepository ;
    private final DividendsConverter dividendsConverter;


    @Autowired
    public DefaultDividendService(DividendsRepository dividendsRepository, DividendsConverter dividendsConverter) {
        this.dividendsRepository = dividendsRepository;
        this.dividendsConverter = dividendsConverter;
    }



    /*    @Override
    public DividendsDto saveDividends(DividendsDto dividendsDto) {
        try {
            validateUserDto(dividendsDto);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        Dividends dividends = dividendsConverter.fromDividendDtoToDividends(dividendsDto);
        Dividends savedDividends = dividendsRepository.save(dividends);

        return  dividendsConverter.fromDividendDtoToDividends(savedDividends);

    }*/


    @Override
    public void deleteDividends(Integer id) {
        dividendsRepository.deleteById(id);
    }





    @Override
    public List<DividendsDto> findAll() {
        return dividendsRepository.findAll()
                .stream()
                .map(dividendsConverter::FFF)
                .collect(Collectors.toList());
    }





    @Override
    public DividendsDto findById(Integer id) {
        Dividends dividends = dividendsRepository.findByid(id);
        if (dividends != null) {
            return dividendsConverter.fromDividendsDtoToUserDto(dividends);
        }
        return null;
    }







    private void validateUserDto(DividendsDto dividendsDto) throws ValidationException {
        if (isNull(dividendsDto)) {
            throw new ValidationException("Object is null");
        }
        if (isNull(dividendsDto.getCurrentCompany()) || dividendsDto.getCurrentPrice() == null) {
            throw new ValidationException("Current company or current price is empty");
        }
    }














}
