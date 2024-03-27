package com.cleancodecamp.java.spring.strategypattern.injection.list.context;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class OrderService2Test {
	@Autowired
	private OrderService2 testee;
	
	@Test
	public void shouldAutowire() {
		assertNotNull(testee);
	}
	
	private Order2 order;
	
	@BeforeAll
	public void setUp() {
		order = new Order2();
		order.setTotalAmount(BigDecimal.ONE);
	}
	
	@Test
	public void shouldPayWithBankAccount() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, "BANK_ACCOUNT_PAYMENT_STRATEGY");
		
		// then - see log
	}
	
	@Test
	public void shouldPayWithCreditCard() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, "CREDIT_CARD_PAYMENT_STRATEGY");
		
		// then - see log
	}
	
	@Test
	public void shouldPayWithPayPal() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, "PAYPAL_PAYMENT_STRATEGY");
		
		// then - see log
	}
	
	@Test
	public void shouldFailWithUnkownType() throws Exception {
		// given - see setUp
		
		// when
		assertThrows(UnsupportedOperationException.class, () -> testee.processOrder(order, "XXX"));
		
		// then - see log
	}
}
