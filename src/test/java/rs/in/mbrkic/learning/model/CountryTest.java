package rs.in.mbrkic.learning.model;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = {"unit", "model", "rs.in.mbrkic.learning.model.CountryTest"})
public class CountryTest {
	
	private static final Logger log = Logger.getLogger(CountryTest.class);
	
	//~ class under test
	private Country country;
	
	@BeforeTest
	private void setUp() {
		country = new Country();
		
		Assert.assertNotNull(country);
	}
	
	@Test(expectedExceptions = {IllegalArgumentException.class})
	public void testMethodGetNameWithArguments() {
		String result = country.getNameWithArgument(null);
	}
	
	public void testBarakObama() {
		String result = country.getNameWithArgument("Barak Obama");
		
		Assert.assertEquals(result, "Makedonija");
	}
	
	public void testBarakObamaNotEquals() {
		String result = country.getNameWithArgument("Barak Obama");
		
		Assert.assertNotEquals(result, "Srbija");
	}
	
	public void testHrvatska() {
		String result = country.getNameWithArgument("Hrvoje");
		
		Assert.assertEquals(result, "Hrvatska");
	}
	
	public void testSrbija(){
		String result = country.getNameWithArgument("Miloje");
		
		Assert.assertEquals(result, "Srbija");
	}
	
	public void testToString(){
		// Country country = new Country(1, "Srbija");
		Country country = new Country();
		country.setId(1);
		country.setName("Srbija");
		
		// System.out.println(country.toString());
		log.info(country);
		
		Assert.assertNotNull(country.toString());
		Assert.assertTrue(country.toString().contains("Country[id="));
		Assert.assertEquals(country.toString(), "Country[id=1,name=Srbija]");
		Assert.assertNotEquals(country.toString(), "Country[id=2,name=Srbija]");
	}
	
	public void testEqualsNotOk() {
		Country srbija = new Country(1, "Srbija");
		Country srbija2 = new Country(2, "Srbija");
		
		Assert.assertFalse(srbija.equals(srbija2));
	}
	
	public void testEqualsOk() {
		Country srbija = new Country(1, "Srbija");
		Country srbija2 = new Country(1, "Srbija");
		
		Assert.assertTrue(srbija.equals(srbija2));
	}

}
