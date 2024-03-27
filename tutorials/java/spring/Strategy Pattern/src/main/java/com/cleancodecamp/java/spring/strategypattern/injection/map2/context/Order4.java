package com.cleancodecamp.java.spring.strategypattern.injection.map2.context;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order4 {
	private UUID id;
	@Setter
	private BigDecimal totalAmount;
	
	public Order4() {
		this.id = UUID.randomUUID();
	}
}
