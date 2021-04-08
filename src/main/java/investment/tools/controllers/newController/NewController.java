package investment.tools.controllers.newController;


import investment.tools.entity.exampleOneToOne.Dividends;
import investment.tools.repository.DividendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8084")

@RestController
@RequestMapping("/api")
public class NewController {


@Autowired
DividendsRepository dividendsRepository;


@GetMapping("/tt")
   public  List<Dividends> getAll(){
   return null;
}


}
