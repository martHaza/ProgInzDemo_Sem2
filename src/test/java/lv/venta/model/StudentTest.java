package lv.venta.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {
	
	Student testStudent1 = new Student("Janis", "Berzins");
	Student testStudent2 = new Student("23652764", "A");
	Student testStudent3 = new Student(null, null);

	@Test
	void testApprovedStudent() {
		assertEquals("Janis", testStudent1.getName());
		assertEquals("Berzins", testStudent1.getSurname());
	}
	
	@Test
	void testFailedStudent() {
		assertNull(testStudent2.getName());
		assertNull(testStudent2.getSurname());
	}
	
	@Test
	void testNullStudent() {
		assertEquals(null, testStudent3.getName());
		assertEquals(null, testStudent3.getSurname());
	}

}
