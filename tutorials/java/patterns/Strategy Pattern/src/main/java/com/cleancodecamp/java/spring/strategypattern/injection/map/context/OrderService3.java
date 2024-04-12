package com.cleancodecamp.java.spring.strategypattern.injection.map.context;

public interface OrderService3 {
	
	void processOrder(Order3 order, String paymentStrategyName);
}
