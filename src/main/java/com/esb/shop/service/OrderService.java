package com.esb.shop.service;

import com.esb.shop.model.Order;
import com.esb.shop.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order non trouvé avec l'id " + id
                ));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // VERSION CORRIGÉE : on ne touche pas à orderItems ici
    public Order updateOrder(Long id, Order orderDetails) {
        Order order = getOrderById(id);

        order.setStatus(orderDetails.getStatus());
        order.setTotalAmount(orderDetails.getTotalAmount());
        order.setCustomer(orderDetails.getCustomer());
        // NE PAS faire : order.setOrderItems(orderDetails.getOrderItems());

        orderRepository.save(order);

        // on recharge depuis la base pour avoir l'objet complet
        return orderRepository.findById(order.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order non trouvé après mise à jour"
                ));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Order non trouvé avec l'id " + id
            );
        }
        orderRepository.deleteById(id);
    }
}
