package com.atmosware.unitTestingDemo.businessTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.atmosware.unitTestingDemo.business.concretes.MathManager;
public class MathManagerTests {

	@Test
	public void one_plus_seven_is_eight() {

		// arange
		MathManager mathManager = new MathManager();

		int number1 = 1;
		int number2 = 7;
		int expected = 8;

		// act
		int actual = mathManager.add(number1, number2);

		// assert
		Assertions.assertEquals(expected, actual);

	}

	@Test
	public void mines_plus_seven_is_six() {

		// arange
		MathManager mathManager = new MathManager();

		int number1 = -1;
		int number2 = 7;
		int expected = 6;

		// act
		int actual = mathManager.add(number1, number2);

		// assert
		Assertions.assertEquals(expected, actual);

	}

}
