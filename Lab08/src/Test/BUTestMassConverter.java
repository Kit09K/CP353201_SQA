package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import sqa.main.MassConverter;

class BUTestMassConverter {

	@ParameterizedTest
    @CsvFileSource(resources = "/MassCSV.csv", numLinesToSkip = 1)
    void testMassConversion(double value, String fromUnit, String toUnit, double expected) {
		MassConverter converter = new MassConverter(); 
	    double actual = converter.convert(value, fromUnit, toUnit);
        assertEquals(expected, actual, 0.01); 
    }

}
