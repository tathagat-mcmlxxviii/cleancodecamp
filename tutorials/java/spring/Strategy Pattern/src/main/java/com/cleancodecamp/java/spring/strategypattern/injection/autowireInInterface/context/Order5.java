package com.cleancodecamp.java.spring.strategypattern.injection.autowireInInterface.context;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order5 {
	private UUID id;
	@Setter
	private BigDecimal totalAmount;
	
	public Order5() {
		this.id = UUID.randomUUID();
	}
}
