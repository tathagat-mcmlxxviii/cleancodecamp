package com.cleancodecamp.java.spring.strategypattern.injection.list.context;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order2 {
	private UUID id;
	@Setter
	private BigDecimal totalAmount;
	
	public Order2() {
		this.id = UUID.randomUUID();
	}
}
