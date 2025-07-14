package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.RomanNumerals;

class Negative {
	
	RomanNumerals roman = new RomanNumerals();

	@Test
	public void testInvalidCharacter() {
		assertThrows(NullPointerException.class, () -> roman.convertRomanNumToInt("JADBC"));
    }
	@Test
	public void testInvalidCharacterLower() {
		assertThrows(NullPointerException.class, () -> roman.convertRomanNumToInt("x"));
    }
	@Test
    public void testWrongRepeatingDigits_VV() {
		assertNotEquals(10,roman.convertRomanNumToInt("VV")); 
    }
	@Test
	public void testWrongRepeatingDigits_LL() {
		assertNotEquals(100,roman.convertRomanNumToInt("LL"));
    }
	@Test
	public void testTooManyRepeats_IIII() {
		assertNotEquals(4,roman.convertRomanNumToInt("IIII"));
    }
	@Test
	public void testTooManyRepeats_XXXX() {
		assertNotEquals(40,roman.convertRomanNumToInt("XXXX"));
    }
	@Test
	public void testTooManyRepeats_CCCC() {
		assertNotEquals(400,roman.convertRomanNumToInt("CCCC"));
    }
	@Test
	public void testTooManyRepeats_MMMM() {
		assertNotEquals(4000,roman.convertRomanNumToInt("MMMM"));
    }
	@Test
	public void testEmptyString() {
		assertEquals(0,roman.convertRomanNumToInt(""));
    }
	

}
