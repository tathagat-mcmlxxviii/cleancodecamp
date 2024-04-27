package com.cleancodecamp.async.service;

import org.springframework.stereotype.Component;

@Component
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

	@Override
	public void makeCoffee(String coffeePowder) {
		try {
			Thread.sleep(200l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
