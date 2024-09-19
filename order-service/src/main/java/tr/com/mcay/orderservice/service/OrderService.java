package tr.com.mcay.orderservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.client.RestTemplate;
import tr.com.mcay.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.mcay.orderservice.model.Orders;

import java.util.List;

@Service
public class OrderService {
    private final RestTemplate restTemplate;
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository,RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    public Orders updateOrder(Orders order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackProductService")
    @RateLimiter(name = "getProductDetailsRateLimiter")
    @Retry(name = "getProductDetailsRetry",fallbackMethod ="fallbackProductServiceRetry" )
    public String getProductDetails(Long productId) {
        return restTemplate.getForObject("http://product-service:8081/products/" + productId, String.class);
    }

    @Retry(name = "getProductDetailsRetry",fallbackMethod ="fallbackProductServiceRetry" )
    public String getProductDetailsRetry(Long productId) {
        return restTemplate.getForObject("http://product-service:8081/products/" + productId, String.class);
    }
    public String fallbackProductService(Long productId, Throwable throwable) {
        return "Product service is currently unavailable. Please try again later. "+throwable.getMessage();
    }
    public String fallbackProductServiceRetry(Long productId, Throwable throwable) {
        System.out.println("Yeniden Deneme Yapılıyor");
        return "Product service is currently unavailable. Please try again later. "+throwable.getMessage();
    }
}
