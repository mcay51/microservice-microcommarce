package tr.com.mcay.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.stockservice.model.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
