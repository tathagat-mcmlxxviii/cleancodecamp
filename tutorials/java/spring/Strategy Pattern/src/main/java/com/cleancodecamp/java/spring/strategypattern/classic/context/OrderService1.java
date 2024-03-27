package com.cleancodecamp.java.spring.strategypattern.classic.context;

import com.cleancodecamp.java.spring.strategypattern.classic.strategy.PaymentStrategy1;

public interface OrderService1 {
	
	void processOrder(Order1 order, PaymentStrategy1 paymentStrategy);
}
