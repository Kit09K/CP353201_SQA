package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import sqa.main.ShippingVehicle;

public class CategoryTest {
	private ShippingVehicle shippingVehicle;	
	
	@BeforeEach
	void setUp() {
		shippingVehicle = new ShippingVehicle();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/shipping-data.csv", numLinesToSkip = 1)
	void Shipping(int small, int medium, int large, int e1, int e2, int e3) {
		List<Integer> expected = (e1 == -1) ? List.of(-1) : List.of(e1,e2,e3);
		List<Integer> result = shippingVehicle.calculate(small, medium, large);
		assertEquals(expected, result);
	}
	

}