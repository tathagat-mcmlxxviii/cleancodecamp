package com.cleancodecamp.java.spring.strategypattern.injection.map.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleancodecamp.java.spring.strategypattern.injection.map.strategy.PaymentStrategyService3;

@Service
public class OrderService3Impl implements OrderService3 {
	
	@Autowired
	private PaymentStrategyService3 paymentStrategyFactory;

	@Override
	public void processOrder(Order3 order, String paymentStrategyName) {
		paymentStrategyFactory.processPayment(order.getId(), order.getTotalAmount(), paymentStrategyName);
	}

}
