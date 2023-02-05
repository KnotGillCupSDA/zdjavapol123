package com.sda.testingadvanced.mockito.captors.appender;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppenderTest {

	@Mock
	private Receiver receiver;


	@Test
	void shouldAppendAsTestSuffix() {

		Appender appender = new Appender(receiver, "-suffix");
		appender.append("xyz");

		//assert that result equals "xyz-suffix"
		//assert that receiver has been called with "xyz-suffix"

		verify(receiver, times(1)).accept("xyz-suffix");
	}
}