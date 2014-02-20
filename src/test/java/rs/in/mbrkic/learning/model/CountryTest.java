package rs.in.mbrkic.learning.model;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = {"unit", "model", "rs.in.mbrkic.learning.model.CountryTest"})
public class CountryTest {
	
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

}
