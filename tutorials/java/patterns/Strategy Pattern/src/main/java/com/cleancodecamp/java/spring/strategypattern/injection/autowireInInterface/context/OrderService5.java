package com.cleancodecamp.java.spring.strategypattern.injection.autowireInInterface.context;

import com.cleancodecamp.java.spring.strategypattern.injection.autowireInInterface.strategy.PaymentStrategy5;

public interface OrderService5 {
	
	void processOrder(Order5 order, String paymentStrategyName);
	
	void registerStrategy(String name, PaymentStrategy5 paymentStrategy);
}
