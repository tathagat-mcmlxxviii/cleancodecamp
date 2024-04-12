package com.cleancodecamp.java.spring.strategypattern.injection.map.strategy;

import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentStrategy3 {
	void pay(UUID orderId, BigDecimal amount);
	
	String getName();
}
