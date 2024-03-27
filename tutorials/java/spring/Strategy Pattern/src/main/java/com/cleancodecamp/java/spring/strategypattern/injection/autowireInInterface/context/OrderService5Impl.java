package com.cleancodecamp.java.spring.strategypattern.injection.autowireInInterface.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cleancodecamp.java.spring.strategypattern.injection.autowireInInterface.strategy.PaymentStrategy5;

@Service
public class OrderService5Impl implements OrderService5 {
	
	private Map<String, PaymentStrategy5> paymentStrategies = new HashMap<>();
	
	@Override
	public void processOrder(Order5 order, String paymentStrategyName) {
		PaymentStrategy5 paymentStrategy = paymentStrategies.get(paymentStrategyName);
		if (paymentStrategy==null)
			throw new UnsupportedOperationException();
		
		paymentStrategy
			.pay(order.getId(), order.getTotalAmount());
	}

	@Override
	public void registerStrategy(String name, PaymentStrategy5 paymentStrategy) {
		paymentStrategies.put(name, paymentStrategy);
	}

}
