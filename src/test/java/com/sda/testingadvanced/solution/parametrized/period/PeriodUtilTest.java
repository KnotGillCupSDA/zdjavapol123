package com.sda.testingadvanced.solution.parametrized.period;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.sda.testingadvanced.parametrized.period.PeriodUtil;

public class PeriodUtilTest {
	private static Instant getInstant(int year, int month, int dayOfMonth) {
		return LocalDate.of(year, month, dayOfMonth).atStartOfDay().toInstant(ZoneOffset.UTC);
	}

	public static Stream<Arguments> shouldReturnExpectedMonth() {
		return Stream.of(
				Arguments.of(
						getInstant(2023, 2, 5),
						getInstant(2023, 3, 4),
						YearMonth.of(2023, 2)),
				Arguments.of(
						getInstant(2023, 2, 5),
						null,
						YearMonth.of(2023, 2))
		);
	}

	@ParameterizedTest
	@MethodSource
	void shouldReturnExpectedMonth(Instant from, Instant to, YearMonth expected) {
		assertEquals(expected, PeriodUtil.getPeriod(from, to));
	}
}