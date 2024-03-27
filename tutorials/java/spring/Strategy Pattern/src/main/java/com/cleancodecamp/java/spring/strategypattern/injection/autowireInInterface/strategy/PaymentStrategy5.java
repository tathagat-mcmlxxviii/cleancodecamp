package com.cleancodecamp.java.spring.strategypattern.injection.autowireInInterface.strategy;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.cleancodecamp.java.spring.strategypattern.injection.autowireInInterface.context.OrderService5;

public interface PaymentStrategy5 {
	void pay(UUID orderId, BigDecimal amount);
	
	String getName();
	
	@Autowired
	default void registerContext(OrderService5 orderService5) {
		orderService5.registerStrategy(getName(), this);
	}
}
