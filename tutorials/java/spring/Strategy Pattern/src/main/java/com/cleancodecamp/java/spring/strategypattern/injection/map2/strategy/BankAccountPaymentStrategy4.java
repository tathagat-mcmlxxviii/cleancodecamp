package com.cleancodecamp.java.spring.strategypattern.injection.map2.strategy;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
public class BankAccountPaymentStrategy4 implements PaymentStrategy4 {
	
	@Getter
	private String name = "BANK_ACCOUNT_PAYMENT_STRATEGY";

	@Override
	public void pay(UUID orderId, BigDecimal amount) {
		System.out.println(MessageFormat.format("Paying {0} with BANK ACCOUNT for order ID {1}",  amount, orderId));
	}

}
