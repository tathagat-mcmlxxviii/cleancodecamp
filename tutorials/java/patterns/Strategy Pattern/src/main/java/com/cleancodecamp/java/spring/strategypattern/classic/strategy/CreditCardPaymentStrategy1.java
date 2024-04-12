package com.cleancodecamp.java.spring.strategypattern.classic.strategy;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentStrategy1 implements PaymentStrategy1 {

	@Override
	public void pay(UUID orderId, BigDecimal amount) {
		System.out.println(MessageFormat.format("Paying {0} with CREDIT CARD for order ID {1}",  amount, orderId));
	}

}
