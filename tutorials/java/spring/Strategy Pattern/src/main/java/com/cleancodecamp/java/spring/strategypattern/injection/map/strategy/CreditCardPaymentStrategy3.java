package com.cleancodecamp.java.spring.strategypattern.injection.map.strategy;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
public class CreditCardPaymentStrategy3 implements PaymentStrategy3 {
	
	@Getter
	private String name = "CREDIT_CARD_PAYMENT_STRATEGY";

	@Override
	public void pay(UUID orderId, BigDecimal amount) {
		System.out.println(MessageFormat.format("Paying {0} with CREDIT CARD for order ID {1}",  amount, orderId));
	}

}
