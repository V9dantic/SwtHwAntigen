package test;

import main.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TestCalendar {

	@ParameterizedTest
	@ValueSource(ints = {2016, 2020, 2024, 2028, 2032})
	public void Should_return_true(int year) {
		
		Calendar c = new Calendar(year);
		assertTrue(c.isLeapYear());
	}

	@ParameterizedTest
	@ValueSource(ints = {2017, 2021, 2025, 2029, 2033})
	public void Should_return_false(int year) {
		
		
		Calendar c = new Calendar(year);
		assertFalse(c.isLeapYear());
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 1333, 108, 2020, 1999})
	public void Should_return_if_year_is_leap(int year) {
		
		Calendar c = new Calendar(year);
		GregorianCalendar g = new GregorianCalendar();
		assertEquals(g.isLeapYear(year), c.isLeapYear());
	}

	@Test
	public void BoundaryTest() {
		
		Calendar c1 = new Calendar(0);
		assertFalse(c1.isLeapYear());
		
		Calendar c2 = new Calendar(Integer.MIN_VALUE);
		assertFalse(c2.isLeapYear());
		
		Calendar c3 = new Calendar(1);
		assertFalse(c3.isLeapYear());
		
		Calendar c4 = new Calendar(Integer.MAX_VALUE);
		GregorianCalendar g = new GregorianCalendar();
		assertEquals(g.isLeapYear(Integer.MAX_VALUE), c4.isLeapYear());
	}

}
