package tr.com.mcay.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.productservice.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}

