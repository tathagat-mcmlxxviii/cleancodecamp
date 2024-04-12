package com.cleancodecamp.java.spring.strategypattern.injection.list.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleancodecamp.java.spring.strategypattern.injection.list.strategy.PaymentStrategyService2;

@Service
public class OrderService2Impl implements OrderService2 {
	
	@Autowired
	private PaymentStrategyService2 paymentStrategyFactory;

	@Override
	public void processOrder(Order2 order, String paymentStrategyName) {
//		paymentStrategy.pay(order.getId(), order.getTotalAmount());
		paymentStrategyFactory.processPayment(order.getId(), order.getTotalAmount(), paymentStrategyName);
	}

}
