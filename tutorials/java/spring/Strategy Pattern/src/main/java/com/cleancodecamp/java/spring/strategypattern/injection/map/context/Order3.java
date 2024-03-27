package com.cleancodecamp.java.spring.strategypattern.injection.map.context;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order3 {
	private UUID id;
	@Setter
	private BigDecimal totalAmount;
	
	public Order3() {
		this.id = UUID.randomUUID();
	}
}
