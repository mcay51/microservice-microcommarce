package tr.com.mcay.orderservice.repository;

import tr.com.mcay.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
