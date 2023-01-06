package vttp2022.paf.assessment.eshop.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.models.OrderStatus;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;

@Service
public class WarehouseService {
	@Autowired
	private OrderRepository orderRepo;

	@Transactional
	// You cannot change the method's signature
	// You may add one or more checked exceptions
	public OrderStatus dispatch(Order order) {

		// TODO: Task 4
		String deliveryId = UUID.randomUUID().toString().substring(0, 8); //to create a random id for the order
		order.setDeliveryId(deliveryId);

		return null;
	
	
	
	
	} 
}
