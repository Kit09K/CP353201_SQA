package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.RomanNumerals;

class Positive {

	RomanNumerals roman = new RomanNumerals();
	
	@Test
	public void testBasic() {
		RomanNumerals obj = new RomanNumerals();
		int output_f = obj.convertRomanNumToInt("I");
		assertEquals(1,output_f);
		assertEquals(5, obj.convertRomanNumToInt("V"));
        assertEquals(10, obj.convertRomanNumToInt("X"));
        assertEquals(50, obj.convertRomanNumToInt("L"));
        assertEquals(100, obj.convertRomanNumToInt("C"));
        assertEquals(500, obj.convertRomanNumToInt("D"));
        assertEquals(1000, obj.convertRomanNumToInt("M"));
	}
	
	@Test
    public void testTwoDigitsFirstSmaller() {
        assertEquals(4, roman.convertRomanNumToInt("IV"));
        assertEquals(9, roman.convertRomanNumToInt("IX"));
    }
	
	@Test
    public void testTwoDigitsFirstLarger() {
        assertEquals(6, roman.convertRomanNumToInt("VI"));
        assertEquals(101, roman.convertRomanNumToInt("CI"));
    }
	
	@Test
    public void testTwoDigitsSame() {
        assertEquals(20, roman.convertRomanNumToInt("XX"));
        assertEquals(4, roman.convertRomanNumToInt("IV"));
        assertEquals(9, roman.convertRomanNumToInt("IX"));
        assertEquals(40, roman.convertRomanNumToInt("XL"));
        assertEquals(90, roman.convertRomanNumToInt("XC"));
        assertEquals(400, roman.convertRomanNumToInt("CD"));
        assertEquals(900, roman.convertRomanNumToInt("CM"));
    }
	
	@Test
    public void testMultipleSameDigits() {
        assertEquals(3, roman.convertRomanNumToInt("III"));
        assertEquals(30, roman.convertRomanNumToInt("XXX"));
    }
	
	@Test
    public void testFirstDigitLargerThanRest() {
        assertEquals(26, roman.convertRomanNumToInt("XXVI"));
        assertEquals(27, roman.convertRomanNumToInt("XXVII"));
        assertEquals(67, roman.convertRomanNumToInt("LXVII"));
    }
	
	@Test
    public void testSimpleNumerals() {
        RomanNumerals obj = new RomanNumerals();
        assertEquals(2, obj.convertRomanNumToInt("II"));
        assertEquals(3, obj.convertRomanNumToInt("III"));
        assertEquals(6, obj.convertRomanNumToInt("VI"));
        assertEquals(20, obj.convertRomanNumToInt("XX"));
    }
	
	@Test
    public void testComplexCombinations() {
        assertEquals(74, roman.convertRomanNumToInt("LXXIV"));
        assertEquals(76, roman.convertRomanNumToInt("LXXVI"));
        assertEquals(78, roman.convertRomanNumToInt("LXXVIII"));
        assertEquals(84, roman.convertRomanNumToInt("LXXXIV"));
    }
	
	

}
