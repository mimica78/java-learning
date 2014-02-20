package rs.in.mbrkic.learning.service;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rs.in.mbrkic.learning.model.Contact;
import rs.in.mbrkic.learning.model.Country;

@Test(groups = {"unit", "service", "rs.in.mbrkic.learning.service.ContactManagerInMemoryImplTest"})
public class ContactManagerInMemoryImplTest {
	
	private static final Logger log = Logger.getLogger(CountryServiceInMemoryImplTest.class);
	
	//~ class under test
	private ContactManagerInMemoryImpl contactManagerService;
	
	@BeforeMethod
	private void setUp() {
		contactManagerService = new ContactManagerInMemoryImpl();
		Assert.assertNotNull(contactManagerService);
	}
	
	// void delete(Integer contactId);
	public void testDeleteContact(int contactId) {
		contactManagerService.delete(contactId);
		Assert.assertNull(contactId);
	}

	// Contact update(Contact itemToUpdate);
	public void testEditContact() {
		Contact contactToEdit = new Contact();
		contactToEdit.getId();
		contactToEdit.setFirstName("Miroslava");
		contactToEdit.setLastName("Brkic");
		contactToEdit.setAddress("Kosovska 24/2");
		contactToEdit.setPhone("0648566263");
//kako se edituje zemlja		
//		Country country = new Country(1, "Srbija");
//		contactToEdit.updateCountry(countryId);
		
		Contact result = contactManagerService.update(contactToEdit);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getPhone(), "0648566263");
	}
	
	
	// Contact selectOne(Integer contactId);
	
	// List<Contact> selectAll();
	
	public void testAddContact() {
		Contact contactToAdd = new Contact();
		contactToAdd.setId(1);
		contactToAdd.setFirstName("Miroslava");
		contactToAdd.setLastName("Brkic");
		contactToAdd.setAddress("Kosovska 24");
		contactToAdd.setPhone("0638566263");
		
		Country country = new Country(1, "Srbija");
		contactToAdd.setCountry(country);
		
		Contact result = contactManagerService.addContact(contactToAdd);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getId().intValue(), 1);
		Assert.assertTrue(contactManagerService.selectAll().size() == 1);
	}



}
