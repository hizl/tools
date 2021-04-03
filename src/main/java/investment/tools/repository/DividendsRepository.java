package investment.tools.repository;

import investment.tools.entity.Dividends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendsRepository extends JpaRepository<Dividends, Integer> {



    Dividends findByid(Integer id);
}
