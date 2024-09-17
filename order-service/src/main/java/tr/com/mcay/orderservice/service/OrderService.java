package tr.com.mcay.orderservice.service;

import tr.com.mcay.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.mcay.orderservice.model.Orders;

import java.util.List;

@Service
public class OrderService {


    private OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
}
