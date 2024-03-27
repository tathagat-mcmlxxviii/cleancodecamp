package com.cleancodecamp.java.spring.strategypattern.classic.context;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cleancodecamp.java.spring.strategypattern.classic.strategy.BankAccountPaymentStrategy1;
import com.cleancodecamp.java.spring.strategypattern.classic.strategy.CreditCardPaymentStrategy1;
import com.cleancodecamp.java.spring.strategypattern.classic.strategy.PayPalPaymentStrategy1;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class OrderService1Test {
	@Autowired
	private OrderService1 testee;
	
	@Autowired
	private BankAccountPaymentStrategy1 bankAccountPaymentStrategy;
	@Autowired
	private CreditCardPaymentStrategy1 creditCardPaymentStrategy;
	@Autowired
	private PayPalPaymentStrategy1 palPaymentStrategy;
	
	@Test
	public void shouldAutowire() {
		assertNotNull(testee);
	}
	
	private Order1 order;
	
	@BeforeAll
	public void setUp() {
		order = new Order1();
		order.setTotalAmount(BigDecimal.ONE);
	}
	
	@Test
	public void shouldPayWithBankAccount() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, bankAccountPaymentStrategy);
		
		// then - see log
	}
	
	@Test
	public void shouldPayWithCreditCard() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, creditCardPaymentStrategy);
		
		// then - see log
	}
	
	@Test
	public void shouldPayWithPayPal() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, palPaymentStrategy);
		
		// then - see log
	}
}
