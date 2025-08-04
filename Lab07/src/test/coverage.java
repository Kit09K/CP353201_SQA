package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import sqa.main.CountWordClumps;

class coverage {

	@ParameterizedTest
	@CsvFileSource(resources = "coverage.csv", numLinesToSkip = 1)
	void testCountClumps(String inputStr, int expected) {
		int[] input = parseIntArray(inputStr);
		int actual = CountWordClumps.countClumps(input);
		assertEquals(expected, actual);
	}

	
	static int[] parseIntArray(String s) {
		if (s == null || s.isBlank() || s.equals("{}"))
			return (s == null || s.isBlank()) ? null : new int[0];
		s = s.replaceAll("[{}\\s]", "");
		if (s.isEmpty())
			return new int[0];
		String[] nums = s.split(",");
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			arr[i] = Integer.parseInt(nums[i]);
		return arr;
	}

}
