package com.School;

/*
 * Corey Denny
 * SNHU CS-320-T4209
 */

public class Contact {

	private static final int CONTACT_PHONENUM_LENGTH = 10;
	private static final byte CONTACT_ID_LENGTH = 10;
	private static final byte CONTACT_FNAME_LENGTH = 10;
	private static final byte CONTACT_LNAME_LENGTH = 10;
	private static final byte CONTACT_ADDRESS_LENGTH = 30;
	private static final String INITIALIZER = "INITIAL";
	private static final String INITIALIZER_NUM = "7045551234";

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String contactId = "111111111"; // Used for JUnit test

	Contact() {
		this.firstName = INITIALIZER;
		this.lastName = INITIALIZER;
		this.phoneNumber = INITIALIZER_NUM;
		this.address = INITIALIZER;
		this.contactId = INITIALIZER;
	}

	Contact(String contactId) {
		setContactId(contactId);
		this.lastName = INITIALIZER;
		this.phoneNumber = INITIALIZER_NUM;
		this.address = INITIALIZER;
		this.contactId = INITIALIZER;
	}

	Contact(String firstName, String lastName, String phoneNumber) {
		setFirstName(firstName);
		setLastName(lastName);
		setLastName(phoneNumber);
		this.address = INITIALIZER;
		this.contactId = INITIALIZER;
	}

	Contact(String firstName, String lastName, String phoneNumber, String address) {
		setFirstName(firstName);
		setLastName(lastName);
		setLastName(phoneNumber);
		setAddress(address);
		this.contactId = INITIALIZER;
	}

	public Contact(String firstName, String lastName, String address, String phoneNumber, String contactId) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setContactId(contactId);
	}

	public final String getFirstName() {
		return firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public final String getAddress() {
		return address;
	}

	public final String getContactId() {
		return contactId;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > CONTACT_FNAME_LENGTH) {
			throw new IllegalArgumentException("First name invalid.");
		} else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > CONTACT_LNAME_LENGTH) {
			throw new IllegalArgumentException("Last name invalid.");
		} else {
			this.lastName = lastName;
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		String regex = "[0-9]+";
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Phone number cannot be empty.");
		} else if (phoneNumber.length() != CONTACT_PHONENUM_LENGTH) {
			throw new IllegalArgumentException("Phone number length invalid.");
		} else if (!phoneNumber.matches(regex)) {
			throw new IllegalArgumentException("Only numbers allowed.");
		} else {
			this.phoneNumber = phoneNumber;
		}
	}

	public void setAddress(String address) {
		if (address == null || address.length() > CONTACT_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address invalid.");
		} else {
			this.address = address;
		}
	}

	public void setContactId(String contactId) {
		if (contactId == null || contactId.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Contact ID invalid.");
		} else {
			this.contactId = contactId;
		}
	}
}