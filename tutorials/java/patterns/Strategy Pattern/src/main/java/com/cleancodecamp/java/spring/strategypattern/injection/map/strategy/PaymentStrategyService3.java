package com.cleancodecamp.java.spring.strategypattern.injection.map.strategy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentStrategyService3 {
	
	@Autowired
	private Map<String, PaymentStrategy3> paymentStrategies;
	
	public void processPayment(UUID orderId, BigDecimal amount, String paymentType) {
		PaymentStrategy3 paymentStrategy = paymentStrategies.get(paymentType);
		if (paymentStrategy==null)
			throw new UnsupportedOperationException();
		
		paymentStrategy.pay(orderId, amount);
	}
}
