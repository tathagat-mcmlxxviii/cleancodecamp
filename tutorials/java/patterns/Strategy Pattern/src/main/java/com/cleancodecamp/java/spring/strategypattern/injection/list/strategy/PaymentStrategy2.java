package com.cleancodecamp.java.spring.strategypattern.injection.list.strategy;

import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentStrategy2 {
	void pay(UUID orderId, BigDecimal amount);
	
	String getName();
}
