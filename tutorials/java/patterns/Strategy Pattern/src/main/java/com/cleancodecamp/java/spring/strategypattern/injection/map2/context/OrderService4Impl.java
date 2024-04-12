package com.cleancodecamp.java.spring.strategypattern.injection.map2.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleancodecamp.java.spring.strategypattern.injection.map2.strategy.PaymentStrategyService4;

@Service
public class OrderService4Impl implements OrderService4 {
	
	@Autowired
	private PaymentStrategyService4 paymentStrategyFactory;

	@Override
	public void processOrder(Order4 order, String paymentStrategyName) {
		paymentStrategyFactory.processPayment(order.getId(), order.getTotalAmount(), paymentStrategyName);
	}

}
