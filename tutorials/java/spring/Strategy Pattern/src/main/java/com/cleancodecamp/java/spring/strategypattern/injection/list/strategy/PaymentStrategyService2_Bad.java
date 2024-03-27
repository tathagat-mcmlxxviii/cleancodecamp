package com.cleancodecamp.java.spring.strategypattern.injection.list.strategy;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentStrategyService2_Bad {
	
	@Autowired
	private BankAccountPaymentStrategy2 bankAccountPaymentStrategy2;
	@Autowired
	private CreditCardPaymentStrategy2 cardPaymentStrategy2;
	@Autowired
	private PayPalPaymentStrategy2 payPalPaymentStrategy2;
	
	public void processPayment(UUID orderId, BigDecimal amount, String paymentType) {
		if (paymentType.equals(bankAccountPaymentStrategy2.getName()))
			bankAccountPaymentStrategy2.pay(orderId, amount);
		else if (paymentType.equals(cardPaymentStrategy2.getName()))
			cardPaymentStrategy2.pay(orderId, amount);
		else if (paymentType.equals(payPalPaymentStrategy2.getName()))
			payPalPaymentStrategy2.pay(orderId, amount);
		else
			throw new UnsupportedOperationException();
	}
}
