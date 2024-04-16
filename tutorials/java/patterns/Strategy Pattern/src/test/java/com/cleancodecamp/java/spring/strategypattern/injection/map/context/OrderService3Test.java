package com.cleancodecamp.java.spring.strategypattern.injection.map.context;

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
public class OrderService3Test {
	@Autowired
	private OrderService3 testee;
	
	@Test
	public void shouldAutowire() {
		assertNotNull(testee);
	}
	
	private Order3 order;
	
	@BeforeAll
	public void setUp() {
		order = new Order3();
		order.setTotalAmount(BigDecimal.ONE);
	}
	
	@Test
	public void shouldPayWithBankAccount() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, "bankAccountPaymentStrategy3");
		
		// then - see log
	}
	
	@Test
	public void shouldPayWithCreditCard() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, "creditCardPaymentStrategy3");
		
		// then - see log
	}
	
	@Test
	public void shouldPayWithPayPal() throws Exception {
		// given - see setUp
		
		// when
		testee.processOrder(order, "payPalPaymentStrategy3");
		
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