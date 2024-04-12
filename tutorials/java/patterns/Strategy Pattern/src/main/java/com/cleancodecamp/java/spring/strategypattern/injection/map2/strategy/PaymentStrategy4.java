package com.cleancodecamp.java.spring.strategypattern.injection.map2.strategy;

import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentStrategy4 {
	void pay(UUID orderId, BigDecimal amount);
	
	String getName();
}
