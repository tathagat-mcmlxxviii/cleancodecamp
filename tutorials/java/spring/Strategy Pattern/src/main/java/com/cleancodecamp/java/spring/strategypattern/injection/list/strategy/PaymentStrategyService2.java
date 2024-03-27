package com.cleancodecamp.java.spring.strategypattern.injection.list.strategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentStrategyService2 {
	
	@Autowired
	private List<PaymentStrategy2> paymentStrategies;
	
	public void processPayment(UUID orderId, BigDecimal amount, String paymentType) {
		paymentStrategies.stream()
		.filter(p -> paymentType.equals(p.getName()))
		.findFirst()
		.orElseThrow(UnsupportedOperationException::new)
		.pay(orderId, amount);
	}
}
