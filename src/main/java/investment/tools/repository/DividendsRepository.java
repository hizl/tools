package investment.tools.repository;

import investment.tools.entity.exampleOneToOne.Dividends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendsRepository extends JpaRepository<Dividends, Long> {



    Dividends findByid(Long id);
}
