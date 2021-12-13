package test;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Calculator;


class TestCalculator {

	Calculator calculator = new Calculator();

	@Test
	public void Should_add_two_numbers_and_return_result() {
		int output_c = calculator.add(5, 5);
		assertEquals(10,output_c);
	}

	@ParameterizedTest
	@CsvSource({"4,		1,	5",
	    		"23,	47,	70",
	    		"868,	9, 	877",
	    		"5,   	5, 	10"})
	public void Should_add_two_numbers_and_return_result_parameterized(int valueOne, int valueTwo, int result) {
		assertEquals(result, calculator.add(valueOne, valueTwo),
				() -> valueOne + " + " + valueTwo + " should equal " + result);
	}
	
	@Test
	public void Should_substract_two_numbers_and_return_result() {
		int output_c = calculator.sub(10, 5);
		assertEquals(5,output_c);

	}
	
	@Test
	public void Should_multiply_two_numbers_and_return_result() {
		int output_c = calculator.multiply(5, 5);
		assertEquals(25,output_c);

	}
	
	@Test
	public void Should_divide_two_numbers_and_return_result() {
		double output_c = calculator.divide(10, 5);
		assertEquals(2, output_c, 0);

	}
	
	@Test
	public void Should_throw_an_arithmetic_exception_if_denominator_is_zero() {
		Exception exception = assertThrows(ArithmeticException.class, () ->
			calculator.divide(1, 0));
		assertEquals("/ by zero", exception.getMessage());
	}
}
