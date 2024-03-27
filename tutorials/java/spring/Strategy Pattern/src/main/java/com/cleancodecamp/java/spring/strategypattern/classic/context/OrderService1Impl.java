package com.cleancodecamp.java.spring.strategypattern.classic.context;

import org.springframework.stereotype.Service;

import com.cleancodecamp.java.spring.strategypattern.classic.strategy.PaymentStrategy1;

@Service
public class OrderService1Impl implements OrderService1 {

	@Override
	public void processOrder(Order1 order, PaymentStrategy1 paymentStrategy) {
		// do order specific stuff
		
		// delegate payment to paymentStrategy
		paymentStrategy.pay(order.getId(), order.getTotalAmount());
	}

}
