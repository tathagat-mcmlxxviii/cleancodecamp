package com.cleancodecamp.java.spring.strategypattern.injection.map2.context;

public interface OrderService4 {
	
	void processOrder(Order4 order, String paymentStrategyName);
}
