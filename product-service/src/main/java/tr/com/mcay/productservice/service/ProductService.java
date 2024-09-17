package tr.com.mcay.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tr.com.mcay.productservice.model.Product;
import tr.com.mcay.productservice.repository.ProductRepository;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {

        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
   // @CircuitBreaker(name = "default", fallbackMethod = "fallback")
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public String fallback(Long id, Throwable t) {
        return "Fallback response for product with ID: " + id;
    }
}
