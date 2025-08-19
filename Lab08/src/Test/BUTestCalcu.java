package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import sqa.main.CookingConversionCalculator;

class BUTestCalcu {

	@ParameterizedTest
    @CsvFileSource(resources = "/CalcuCSV.csv", numLinesToSkip = 1)
    void testTopDownIntegration(double value,String choice,  String fromUnit, String toUnit, double expected) {
        CookingConversionCalculator calc = new CookingConversionCalculator();
        double actual = calc.convert(value,choice, fromUnit, toUnit);
        assertEquals(expected, actual, 0.01);
    }

}
