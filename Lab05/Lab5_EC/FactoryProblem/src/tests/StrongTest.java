package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import sqa.main.Income;


class StrongTest {
	private Income income;
	@BeforeEach
	void setUp() {
		income = new Income();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	void IncomeTest(int impeller, int motor, int cover, Double expectedResult) {
		Double Result = income.calculateIncome(impeller, motor, cover);
		assertEquals(expectedResult, Result);
	}
	
}