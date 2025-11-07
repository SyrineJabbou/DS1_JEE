package com.esb.shop.service;

import com.esb.shop.model.OrderItem;
import com.esb.shop.repository.OrderItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "OrderItem non trouvé avec l'id " + id
                ));
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItemDetails) {
        OrderItem orderItem = getOrderItemById(id);
        orderItem.setQuantity(orderItemDetails.getQuantity());
        orderItem.setUnitPrice(orderItemDetails.getUnitPrice());
        orderItem.setProduct(orderItemDetails.getProduct());
        orderItem.setOrder(orderItemDetails.getOrder());
        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "OrderItem non trouvé avec l'id " + id
            );
        }
        orderItemRepository.deleteById(id);
    }
}
