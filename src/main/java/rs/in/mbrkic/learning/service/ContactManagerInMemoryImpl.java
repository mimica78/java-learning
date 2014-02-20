package rs.in.mbrkic.learning.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rs.in.mbrkic.learning.model.Contact;

public class ContactManagerInMemoryImpl implements ContactManager {
	
	private Map<Integer, Contact> contacts = new HashMap<Integer, Contact>();

	public Contact addContact(Contact itemToAdd) {
		contacts.put(itemToAdd.getId(), itemToAdd);
		return itemToAdd;
	}

	public void delete(Integer contactId) {
		contacts.remove(contactId);
	}

	public Contact update(Contact itemToUpdate) {
		contacts.put(itemToUpdate.getId(), itemToUpdate);
		return itemToUpdate;
	}

	public Contact selectOne(Integer contactId) {
		return contacts.get(contactId);
	}

	public List<Contact> selectAll() {
		List<Contact> result = new ArrayList<Contact>();
		for (Integer key : contacts.keySet()) {
			Contact contact = contacts.get(key);
			result.add(contact);
		}
		return result;
	}

	public void clearAll() {
		contacts.clear();
	}

}
