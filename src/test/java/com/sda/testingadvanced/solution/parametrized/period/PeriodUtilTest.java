package com.sda.testingadvanced.solution.parametrized.period;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.sda.testingadvanced.parametrized.period.MyRuntimeException;
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
						YearMonth.of(2023, 2)),
				Arguments.of(
						getInstant(2023, 2, 15),
						getInstant(2023, 3, 14),
						YearMonth.of(2023, 2)),
				Arguments.of(
						getInstant(2023, 2, 22),
						getInstant(2023, 3, 21),
						YearMonth.of(2023, 3)),
				Arguments.of(
						getInstant(2023, 2, 22),
						null,
						YearMonth.of(2023, 3))
		);
	}

	@ParameterizedTest
	@MethodSource
	void shouldReturnExpectedMonth(Instant from, Instant to, YearMonth expected) {
		assertEquals(expected, PeriodUtil.getPeriod(from, to));
	}

	@Test
	void shouldThrowExceptionWhenBothDatesAreMissing() {
		assertThrows(MyRuntimeException.class, () -> PeriodUtil.getPeriod(null, null));
	}
}