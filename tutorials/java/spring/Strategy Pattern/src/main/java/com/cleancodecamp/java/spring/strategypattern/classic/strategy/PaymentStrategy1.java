package com.cleancodecamp.java.spring.strategypattern.classic.strategy;

import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentStrategy1 {
	void pay(UUID orderId, BigDecimal amount);

	// void printMonthlyPaymentReport();
}
