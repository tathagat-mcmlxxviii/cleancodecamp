package com.cleancodecamp.java.spring.strategypattern.injection.list.context;

public interface OrderService2 {
	
	void processOrder(Order2 order, String paymentStrategyName);
}
