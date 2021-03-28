package investment.tools.repository;

import investment.tools.entity.Dividends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendRepository extends JpaRepository<Dividends, Integer> {

    void findById(String id);

}
