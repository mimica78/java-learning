/**
 * 
 */
package rs.in.mbrkic.learning.model;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author m.brkic
 *
 */
@Test(groups = {"unit", "model", "rs.in.mbrkic.learning.model.ContactTest"})
public class ContactTest {
	
	//~ class under test
	private Contact contact;
	
	@BeforeTest
	private void setUp() {
		contact = new Contact();
		
		Assert.assertNotNull(contact);
	}
	
	public void testGetSetId() {
		Assert.assertNotNull(contact);
		contact.setId(1);
		
		Assert.assertEquals(contact.getId().intValue(), 1);
		
		
	}


}
