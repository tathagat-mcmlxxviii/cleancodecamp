package com.cleancodecamp.async.service;

import org.springframework.stereotype.Component;

@Component
public class CoffeeGrinderServiceImpl implements CoffeeGrinderService {

	@Override
	public String grindCoffeeBeans() {
		try {
			Thread.sleep(200l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "coffee powder";
	}

}
