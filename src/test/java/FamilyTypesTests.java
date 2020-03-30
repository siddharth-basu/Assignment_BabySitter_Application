import HelperClasses.FamilyTypes;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class FamilyTypesTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void familiesDefaultConstructorFunctional() {
		FamilyTypes testFamily = new FamilyTypes();
		assertEquals(null, testFamily.getFamily());
	}

	@Test
	public void typeAStringsToIntegers() {
		assertEquals(8, 8, FamilyTypes.TypeAComputation("8", "05", "15", "55"));
		assertEquals(5, 05, FamilyTypes.TypeAComputation("8", "05", "15", "55"));
		assertEquals(15, 15, FamilyTypes.TypeAComputation("8", "05", "15", "55"));
		assertEquals(55, 55, FamilyTypes.TypeAComputation("8", "05", "15", "55"));
	}

	@Test
	public void typeCStringsToIntegers() {
		assertEquals(8, 8, FamilyTypes.TypeCComputation("8", "05", "15", "55"));
		assertEquals(5, 05, FamilyTypes.TypeCComputation("8", "05", "15", "55"));
		assertEquals(15, 15, FamilyTypes.TypeCComputation("8", "05", "15", "55"));
		assertEquals(55, 55, FamilyTypes.TypeCComputation("8", "05", "15", "55"));
	}

	@Test
	public void typeBStringsToIntegers() {
		assertEquals(8, 8, FamilyTypes.TypeBComputation("8", "05", "15", "55"));
		assertEquals(5, 05, FamilyTypes.TypeBComputation("8", "05", "15", "55"));
		assertEquals(15, 15, FamilyTypes.TypeBComputation("8", "05", "15", "55"));
		assertEquals(55, 55, FamilyTypes.TypeBComputation("8", "05", "15", "55"));
	}

	@Test
	public void typeAIsBeginingHourBefore11PM() {
		assertEquals(10, 10, FamilyTypes.TypeAComputation("10", "45", "15", "55"));
	}

	@Test
	public void typeAPayBefore11PM() {
		assertEquals(15, 15, FamilyTypes.TypeAComputation("10", "45", "15", "55"));
		assertEquals(90, 90, FamilyTypes.TypeAComputation("5", "45", "11", "55"));
	}

	@Test
	public void typeATotalPayBeginingBefore11PM() {
		assertTrue(115 == FamilyTypes.TypeAComputation("10", "45", "15", "55"));
		assertTrue(110 == FamilyTypes.TypeAComputation("5", "45", "11", "55"));
		assertTrue(95 == FamilyTypes.TypeAComputation("10", "45", "15", "0"));
	}

	@Test
	public void typeATotalPayBeginingAfter11PM() {
		assertTrue(80 == FamilyTypes.TypeAComputation("12", "45", "15", "55"));
	}

	@Test
	public void typeATotalPayBeginingAt5PM() {
		assertTrue(190 == FamilyTypes.TypeAComputation("5", "0", "15", "55"));
	}


	@Test
	public void typeBIsBeginHourBefore10PM() {
		assertEquals(9, 9, FamilyTypes.TypeBComputation("9", "45", "15", "55"));
	}

	@Test
	public void typeBIsBeginHourBeforeMidnight() {
		assertEquals(11, 11, FamilyTypes.TypeBComputation("12", "45", "15", "55"));
	}

	@Test
	public void typeBIsBeginHourAfterMidnight() {
		assertEquals(12, 12, FamilyTypes.TypeBComputation("12", "45", "15", "55"));
		assertEquals(45, 45, FamilyTypes.TypeBComputation("12", "45", "15", "55"));
	}

	@Test
	public void typeBPayBefore10PM() {
		assertEquals(92, 92, FamilyTypes.TypeBComputation("8", "45", "15", "55"));
		assertEquals(76, 76, FamilyTypes.TypeBComputation("5", "45", "11", "55"));
	}

	@Test
	public void typeBTotalPayBeginBefore10PM() {
		assertTrue(104 == FamilyTypes.TypeBComputation("8", "45", "15", "55"));
		assertTrue(76 == FamilyTypes.TypeBComputation("5", "45", "11", "55"));
		assertTrue(100 == FamilyTypes.TypeBComputation("7", "45", "14", "1"));
	}

	@Test
	public void typeBTotalPayBeginBefore10PMAndEndingIn0Minutes() {
		assertTrue(104 == FamilyTypes.TypeBComputation("8", "45", "16", "0"));
		assertTrue(68 == FamilyTypes.TypeBComputation("5", "45", "11", "0"));
	}

	@Test
	public void typeBTotalPayBeginAfter10PMAndBeforeMidnight() {
		assertTrue(16 == FamilyTypes.TypeBComputation("10", "15", "11", "55"));
		assertTrue(72 == FamilyTypes.TypeBComputation("11", "45", "15", "55"));
	}

	@Test
	public void typeBTotalPayBeginAfter10PMAndBeforeMidnightAndEndingIn0Minutes() {
		assertTrue(8 == FamilyTypes.TypeBComputation("10", "15", "11", "0"));
		assertTrue(56 == FamilyTypes.TypeBComputation("11", "45", "15", "0"));
	}

	@Test
	public void typeBTotalPayBeginAfterMidnight() {
		assertTrue(64 == FamilyTypes.TypeBComputation("12", "45", "15", "55"));
		assertTrue(64 == FamilyTypes.TypeBComputation("12", "1", "16", "0"));
	}

	@Test
	public void typeBTotalPayBeginAt5PM() {
		assertTrue(140 == FamilyTypes.TypeBComputation("5", "0", "15", "55"));
	}

	@Test
	public void typeBTotalPayBeginAt10PM() {
		assertTrue(64 == FamilyTypes.TypeBComputation("10", "0", "15", "0"));
	}

	@Test
	public void typeBTotalPayBeginingAtMidnight() {
		assertTrue(48 == FamilyTypes.TypeBComputation("12", "0", "15", "0"));
	}

	@Test
	public void typeCIsBeginHourBefore9PM() {
		assertEquals(8, 8, FamilyTypes.TypeCComputation("8", "45", "15", "55"));
	}

	@Test
	public void typeCPayBefore9PM() {
		assertEquals(21, 21, FamilyTypes.TypeCComputation("8", "45", "15", "55"));
		assertEquals(84, 84, FamilyTypes.TypeCComputation("5", "45", "11", "55"));
	}

	@Test
	public void typeCTotalPayBeginingAfter9PM() {
		assertTrue(60 == FamilyTypes.TypeCComputation("12", "45", "15", "55"));
	}

	@Test
	public void typeCTotalPayBeginAt5PM() {
		assertTrue(189 == FamilyTypes.TypeCComputation("5", "0", "15", "55"));
	}

	@Test
	public void typeCTotalPayBeginAt9PM() {
		assertTrue(90 == FamilyTypes.TypeCComputation("9", "0", "15", "0"));
	}

	@Test
	public void typeCTotalPayBeginBefore9PM() {
		assertTrue(126 == FamilyTypes.TypeCComputation("8", "45", "15", "55"));
		assertTrue(129 == FamilyTypes.TypeCComputation("5", "45", "11", "55"));
		assertTrue(132 == FamilyTypes.TypeCComputation("7", "45", "15", "0"));
	}

}
