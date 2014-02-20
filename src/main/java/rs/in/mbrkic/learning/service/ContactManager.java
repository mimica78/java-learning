package rs.in.mbrkic.learning.service;

import java.util.List;

import rs.in.mbrkic.learning.model.Contact;

public interface ContactManager {
	
	Contact addContact(Contact itemToAdd);
	
	void delete(Integer contactId);
	
	Contact update(Contact itemToUpdate);
	
	Contact selectOne(Integer contactId);
	
	List<Contact> selectAll();
	
	void clearAll();

}
