package investment.tools.controllers;


import investment.tools.dto.DividendsDto;
import investment.tools.entity.Dividends;
import investment.tools.service.DefaultDividendService;
import investment.tools.service.DividendService;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/d")
@Log

public class DividendsController {


    private  final DividendService dividendService;




    @Autowired
    public DividendsController(DividendService dividendService) {
        this.dividendService = dividendService;
    }





    @GetMapping("/findAll")
    public List<DividendsDto> findAllUsers() {
        log.info("Handling find all users request");
        return dividendService.findAll();
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        dividendService.deleteDividends(id);
        return ResponseEntity.ok().build();
    }



}
