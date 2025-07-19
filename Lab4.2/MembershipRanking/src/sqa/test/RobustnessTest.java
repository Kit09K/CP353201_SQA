package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import sqa.main.Ranking;

class RobustnessTest {
	Ranking ranking;

	@BeforeEach
	void setUp() {
		ranking = new Ranking();
	}

	@ParameterizedTest
	@MethodSource("provideParamStream")
	void testRoburstnessBoundary(int purchaseTotal, int frequency, int pointCollected, String expectedResult) {
		String result = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expectedResult, result);
	}

	private static Stream<Arguments> provideParamStream() {
		return Stream.of(
				Arguments.of(-1, 4, 500, "Error"),
				Arguments.of(0, 4, 500, "Standard"),
				Arguments.of(1, 4, 500, "Standard"),
				Arguments.of(50000, 4, 500, "Gold"),
				Arguments.of(99999, 4, 500, "Gold"),
				Arguments.of(100000, 4, 500, "Gold"),
				Arguments.of(100001, 4, 500, "Standard"),
				Arguments.of(50000, 0, 500, "Standard"),
				Arguments.of(50000, 1, 500, "Sliver"),
				Arguments.of(50000, 2, 500, "Sliver"),
				Arguments.of(50000, 6, 500, "Standard"),
				Arguments.of(50000, 7, 500, "Standard"),
				Arguments.of(50000, 8, 500, "Standard"),
				Arguments.of(50000, 4, 99, "Standard"),
				Arguments.of(50000, 4, 100, "Standard"),
				Arguments.of(50000, 4, 101, "Standard"),
				Arguments.of(50000, 4, 999, "Gold"),
				Arguments.of(50000, 4, 1000, "Gold"),
				Arguments.of(50000, 4, 1001, "Standard"));
	}
}
