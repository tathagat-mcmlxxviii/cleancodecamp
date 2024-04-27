package com.cleancodecamp.async.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoffeeServiceImpl implements CoffeeService {
	
	private CoffeeGrinderService coffeeGrinderService;
	
	private CoffeeMachineService coffeeMachineService;
	
	public CoffeeServiceImpl(CoffeeGrinderService coffeeGrinderService, CoffeeMachineService coffeeMachineService) {
		super();
		this.coffeeGrinderService = coffeeGrinderService;
		this.coffeeMachineService = coffeeMachineService;
	}

	@Override
	public void brewCoffee(int numberOfCoffees) {
		long startTime = System.currentTimeMillis();
		for (int i = 1; i <= numberOfCoffees; i++) {
			log.info("Starting number {} coffee", i);
			String coffeePowder = coffeeGrinderService.grindCoffeeBeans();
			coffeeMachineService.makeCoffee(coffeePowder);
		}
		long endTime = System.currentTimeMillis();
		
		log.info("Took {} seconds to brew {} coffees",
		 (endTime-startTime)/1000,numberOfCoffees);
	}
	
}
