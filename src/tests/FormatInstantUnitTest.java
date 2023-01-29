package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class FormatInstantUnitTest {
	
	private static final String PATTERN_FORMAT = "dd/MM/yyyy";
	
	@Test
	public void givenInstantWhenUsingDateTimeFormatterTthenFormat() {
		
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern(PATTERN_FORMAT).withZone(ZoneId.systemDefault());
		
		Instant instant = Instant.parse("1950-01-05T03:00:00.00Z");
		String formattedInstant = formatter.format(instant);
		
		assertEquals("05/01/1950", formattedInstant);
	}
}
