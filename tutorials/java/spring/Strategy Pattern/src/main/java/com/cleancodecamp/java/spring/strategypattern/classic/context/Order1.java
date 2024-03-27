package com.cleancodecamp.java.spring.strategypattern.classic.context;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order1 {
	private UUID id;
	@Setter
	private BigDecimal totalAmount;
	
	public Order1() {
		this.id = UUID.randomUUID();
	}
}
