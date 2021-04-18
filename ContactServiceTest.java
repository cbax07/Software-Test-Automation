/*
 * Corey Denny
 * SNHU CS-320-T4209
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.School.ContactService;

class ContactServiceTest {
	//Establish correct variables
	String contactId;
	String firstNameTest;
	String lastNameTest;
	String phoneNumberTest;
	String addressTest;
	//Establish error variables
	String tooLongContactId;
	String tooLongFirstName;
	String tooLongLastName;
	String tooLongPhoneNumber;
	String tooShortPhoneNumber;
	String tooLongAddress;

	@BeforeEach
	void setUp() {
		contactId = "111111111";
		firstNameTest = "John";
		lastNameTest = "Smith";
		phoneNumberTest = "7045551234";
		addressTest = "1a Sample St, Random, NY 12345";
		tooLongContactId = "112233445566778899";
		tooLongFirstName = "Geralt Witcherman";
		tooLongLastName = "Bodenheimer";
		tooLongPhoneNumber = "70455512345678";
		tooShortPhoneNumber = "1234567";
		tooLongAddress = "1a Sample St, Random Place in the world, NY 12345";
	}

	@Test
	// Test to see if a new contact is created.
	void newContactTest() {
		ContactService service = new ContactService();
		service.newContact();

		assertAll("service", () -> assertNotNull(contactId, service.getContactList().get(0).getContactId()));
	}

	@Test
	// Test to see if the contact is deleted.
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();

		assertThrows(Exception.class, () -> service.deleteContact(contactId));
		assertAll(() -> service.deleteContact(service.getContactList().get(0).getContactId()));
	}

	@Test
	// Test to see if the contact's first name is added and meets set parameters.
	void updateFirstNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();

		service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
		assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName));

		assertThrows(Exception.class, () -> service.updateFirstName(contactId, firstNameTest));
	}

	@Test
	// Test to see if the contact's last name is added and meets set parameters.
	void updateLastNameTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);

		assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName));
		assertThrows(Exception.class, () -> service.updateLastName(contactId, lastNameTest));
	}

	@Test
	// Test to see if the contact's phone number is added and meets set parameters.
	void updatePhoneNumberTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest);
		assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
		assertThrows(IllegalArgumentException.class,
				() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooLongPhoneNumber));
		assertThrows(IllegalArgumentException.class,
				() -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooShortPhoneNumber));
	}

	@Test
	// Test to see if the contact's address is added and meets set parameters.
	void updateAddressTest() throws Exception {
		ContactService service = new ContactService();
		service.newContact();
		service.updateAddress(service.getContactList().get(0).getContactId(), addressTest);
		assertEquals(addressTest, service.getContactList().get(0).getAddress());
		assertThrows(IllegalArgumentException.class,
				() -> service.updateAddress(service.getContactList().get(0).getContactId(), tooLongAddress));
	}
}