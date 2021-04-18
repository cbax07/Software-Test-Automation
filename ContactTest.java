/*
 * Corey Denny
 * SNHU CS-320-T4209
 */

package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.School.Contact;

public class ContactTest {

	public ContactTest() {
	}

	@Test
	void testContactClass() {
		Contact ContactClass = new Contact("FirstName", "LastName", "220 Wyndham Way", "1234567891", "1234");

		assertTrue(ContactClass.getFirstName().equals("FirstName"));
		assertTrue(ContactClass.getLastName().equals("LastName"));
		assertTrue(ContactClass.getAddress().equals("220 Wyndham Way"));
		assertTrue(ContactClass.getPhoneNumber().equals("1234567891"));
		assertTrue(ContactClass.getContactId().equals("1234"));
	}

	@Test
	// Test to see if the contacts first name is too long.
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName-TooLongExample", "LastName", "220 Wyndham Way", "1234567891", "1234");
		});
	}

	@Test
	// Test to see if the contacts last name is too long.
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName-TooLongExample", "220 Wyndham Way", "1234567891", "1234");
		});
	}

	@Test
	// Test to see if the contacts last name is too long.
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "220 Wyndham Way - TooLongExample", "1234567891", "1234");
		});
	}

	@Test
	// Test to see if the contacts phone number is too long.
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "220 Wyndham Way", "1234567891-TooLongExample", "1234");
		});
	}
}
