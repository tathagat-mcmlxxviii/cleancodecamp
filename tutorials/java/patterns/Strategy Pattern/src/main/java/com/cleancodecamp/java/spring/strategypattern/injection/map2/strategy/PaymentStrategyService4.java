package com.cleancodecamp.java.spring.strategypattern.injection.map2.strategy;
import java.math.BigDecimal;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentStrategyService4 {

	private Map<String, PaymentStrategy4> paymentStrategies;
	
	@Autowired
	public PaymentStrategyService4(List<PaymentStrategy4> paymentStrategiesList) {
		paymentStrategies = paymentStrategiesList.stream()  
			.collect(Collectors.toMap(PaymentStrategy4::getName, Function.identity()));
	}
	
	public void processPayment(UUID orderId, BigDecimal amount, String paymentType) {
		PaymentStrategy4 paymentStrategy = paymentStrategies.get(paymentType);
		if (paymentStrategy==null)
			throw new UnsupportedOperationException();
		
		paymentStrategy.pay(orderId, amount);
	}
}
