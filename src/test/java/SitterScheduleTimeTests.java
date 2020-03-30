import HelperClasses.SitterScheduleTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SitterScheduleTimeTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void verifyTheBabysittersName()
	{
		String nameOfSitter = "Sid";
		assertEquals("Sid", nameOfSitter);
	}

	@Test
	public void  verifySittersBeginingHourCannotBeBefore5PM()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterStartingHour(0, 3));
	}

	@Test
	public void verifySittersBeginingHour5PMOrLater()
	{
		assertEquals("11", SitterScheduleTime.SitterStartingHour(0, 11));
	}

	@Test
	public void  verifySittersBeginingHourBefore4AMOrEarlier()
	{
		assertEquals("12", SitterScheduleTime.SitterStartingHour(1, 0));
	}

	@Test
	public void  verifySittersBeginingHourCannotBeAfter4AM()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterStartingHour(1, 5));
	}

	@Test
	public void  verifySittersBeginingMinute() {
		assertEquals("02", SitterScheduleTime.SitterStartingMinute(2));
	}

	@Test
	public void  verifySittersBeginingHourWhenAnErrorForHourIsGreaterThan11PM()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterStartingHour(1, 12));
	}

	@Test
	public void  verifySittersBeginingHourWhenAnErrorForHourIsANegativeInteger()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterStartingHour(1, -2));
	}

	@Test
	public void  verifySittersBeginingHourWithAnErrorForPMOrAM()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterStartingHour(2, 2));
	}

	@Test
	public void verifySittersBeginingMinuteWithOver59MinutesError()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterStartingMinute(60));
	}

	@Test
	public void verifySittersBeginingMinuteWithNegativeMinutesError()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterStartingMinute(-5));
	}

	@Test
	public void verifySittersEndingHour4AMOrEarlier()
	{
		assertEquals("16", SitterScheduleTime.SitterEndingHour(1, 4));
	}

	@Test
	public void verifySittersEndingHourCannotBeBefore5PM()
	{
		assertEquals("Incorrect Entry. Error. Try again.", SitterScheduleTime.SitterEndingHour(0, 4));
	}

	@Test
	public void verifySittersEndingHourBeforeMidnightOrEarlier()
	{
		assertEquals("10", SitterScheduleTime.SitterEndingHour(0, 10));
	}

	@Test
	public void verifySittersEndingHourCannotBeAfter4AM()
	{
		assertEquals("Incorrect Entry. Error. Try again.", SitterScheduleTime.SitterEndingHour(1, 5));
	}

	@Test
	public void verifySittersEndingHourWhenAnErrorForHourIsANegativeInteger()
	{
		assertEquals("Incorrect Entry. Error. Try again.", SitterScheduleTime.SitterEndingHour(1, -4));
	}

	@Test
	public void verifySittersEndingHourWhenAnErrorForHourIsGreaterThan11AM()
	{
		assertEquals("Incorrect Entry. Error. Try again.", SitterScheduleTime.SitterEndingHour(1, 12));
	}

	@Test
	public void verifySittersEndingHourWithAnErrorForPMOrAM()
	{
		assertEquals("Incorrect Entry. Error. Try again.", SitterScheduleTime.SitterEndingHour(2, 2));
	}

	@Test
	public void verifySittersEndingMinute() {
		assertEquals("02", SitterScheduleTime.SitterEndingMinute(2));
	}

	@Test
	public void verifySittersEndingMinuteWithOver59MinutesError()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterEndingMinute(60));
	}

	@Test
	public void verifySittersEndingMinuteWithNegativeMinutesError()
	{
		assertEquals("Incorrect Entry. Try Again.", SitterScheduleTime.SitterEndingMinute(-10));
	}

	@Test
	public void verifySittersEndingTimeIsSameAsBeginTime()
	{
		assertEquals("Incorrect Entry Error. Try again.", SitterScheduleTime.SitterTotalMinutesSitting("5", "30", "5", "30"));
	}

	@Test
	public void verifySittersEndingTimeIsBeforeBeginTime()
	{
		assertEquals("Incorrect Entry Error. Try again.", SitterScheduleTime.SitterTotalMinutesSitting("5", "30", "5", "15"));
	}

	@Test
	public void verifySittersEndingTimeIsLessThan60MinutesBeforeBeginTime()
	{
		assertEquals("Incorrect Entry Error. Try again.", SitterScheduleTime.SitterTotalMinutesSitting("5", "30", "6", "29"));
	}
	@Test
	public void verifySittersEndingTimeIsNotBeforeStartingTime()
	{
		assertEquals("495", SitterScheduleTime.SitterTotalMinutesSitting("5", "30", "13", "45"));
	}


}
