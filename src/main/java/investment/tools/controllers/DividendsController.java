package investment.tools.controllers;


import investment.tools.dto.DividendsDto;
import investment.tools.service.DividendService;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
@RequestMapping("/d")
public class DividendsController {

    private  final DividendService dividendService;


    @Autowired
    public DividendsController(DividendService dividendService) {
        this.dividendService = dividendService;
    }





    @GetMapping(  "/findAll")
    public List<DividendsDto> findAll() {
        log.info("Handling find all request");
        return dividendService.findAll();
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dividendService.deleteDividends(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/findByLogin")
    public DividendsDto findById(@RequestParam Long id) {
        log.info("Handling find by login request: " + id);
        return dividendService.findById(id);
    }


}
