package com.School;

/*
 * Corey Denny
 * SNHU CS-320-T4209
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

	private String uniqueId;
	private List<Contact> contactList = new ArrayList<>();

	public void newContact() {
		Contact contact = new Contact(newUniqueId());
		contactList.add(contact);
	}

	public void newContact(String firstname, String lastname, String phonenumber, String address) {
		Contact contact = new Contact(firstname, lastname, phonenumber, address, newUniqueId());
		contactList.add(contact);
	}

	public void newContact(String firstname, String lastname, String phonenumber, String address, String contactId) {
		Contact contact = new Contact(firstname, lastname, phonenumber, address, contactId);
		contactList.add(contact);
	}

	public void deleteContact(String id) throws Exception {
		contactList.remove(searchForContact(id));
	}

	public void updateFirstName(String id, String firstName) throws Exception {
		searchForContact(id).setFirstName(firstName);
	}

	public void updateLastName(String id, String lastName) throws Exception {
		searchForContact(id).setLastName(lastName);
	}

	public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
		searchForContact(id).setPhoneNumber(phoneNumber);
	}

	public void updateAddress(String id, String address) throws Exception {
		searchForContact(id).setAddress(address);
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	private String newUniqueId() {
		return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}

	private Contact searchForContact(String id) throws Exception {
		int index = 0;
		while (index < contactList.size()) {
			if (id.equals(contactList.get(index).getContactId())) {
				return contactList.get(index);
			}
			index++;
		}
		throw new Exception("The Task does not exist!");
	}
}