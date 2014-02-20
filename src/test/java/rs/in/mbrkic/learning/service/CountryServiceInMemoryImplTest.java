package rs.in.mbrkic.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rs.in.mbrkic.learning.model.Country;

// napisati grupe
@Test(groups = {"unit", "service", "rs.in.mbrkic.learning.service.CountryManagerInMemoryImplTest"})
public class CountryServiceInMemoryImplTest {
	
	private static final Logger log = Logger.getLogger(CountryServiceInMemoryImplTest.class);
	
	private CountryServiceInMemoryImpl countryService;
	
	@BeforeMethod
	private void setUp() {
		countryService = new CountryServiceInMemoryImpl();
		Assert.assertNotNull(countryService);
	}
	
	// protestirati Add nakon sto dobro implementiras tu metodu
	// u skladu za zahtevima
	public void testAdd() {
		countryService.clearAll();
		log.info("Country list is empty");
		Country country = new Country(1, "Srbija"); 
		Country result = countryService.add(country);
		Country country2 = new Country(1, "Srbija");
		Country result2 = countryService.add(country2);
		List<Country> countries = countryService.selectAll();
		Assert.assertEquals(countries.size(), 1);
		
	}

	public void testFindByNameOk(){
		// Country selectOneByName(String countryName)
		Country country = new Country(1, "Srbija"); 
		Country result = countryService.add(country);
		
		Country mima1 = countryService.selectOneByName("Srbija");
		
		Assert.assertNotNull(mima1);
		Assert.assertEquals(mima1.getId().intValue(), 1);
		Assert.assertEquals(mima1.getName(), "Srbija");
	}

	public void testFindByNameNotOk(){
		// Country selectOneByName(String countryName)
		Country country = new Country(1, "Srbija"); 
		Country result = countryService.add(country);
		
		Country mima1 = countryService.selectOneByName("Hrvatska");
		Assert.assertNull(mima1);
	}
	
	public void testGetOneByIdNotOkExample() {
		// BasicConfigurator.configure();
		log.trace("--- log ispis ---");
		
		countryService.clearAll();
		log.info("Lista je prazna");
		
		Country srbija = new Country(1, "Srbija");
		Country hrvatska = new Country(2, "Hrvatska");
		Country apatin = new Country(3, "Apatin");
		
		Country result1 = countryService.add(apatin);
		Country result2 = countryService.add(hrvatska);
		Country result3 = countryService.add(srbija);
		
		Country glavniResultTestMetode = countryService.selectOneById(1);
		
		Assert.assertNotNull(glavniResultTestMetode);
		Assert.assertEquals(glavniResultTestMetode.getName(), "Srbija");
		log.info(glavniResultTestMetode.getName() + " is selected");		
	}
	
	public void deleteCountryOkTest(){
		//countries.remove(countryId);
		//proveriti da li postoji zemlja
		// Country selectOneByName(String countryName)
		Country country = new Country(1, "Srbija"); 
		Country result = countryService.add(country);
		
		Country mima1 = countryService.selectOneByName("Srbija");
		
		Assert.assertNotNull(mima1);
		Assert.assertEquals(mima1.getId().intValue(), 1);
		Assert.assertEquals(mima1.getName(), "Srbija");
		//ako postoji obrisati
		if (mima1 != null) {
			countryService.delete(mima1.getId());
			log.info(mima1.getName() + " is deleted");
		}
		else{
			log.info("Country "+ mima1.getName() + "does not exist");	
		}
	}

//	public Country deleteCountryNotOkTest(){
//		//countries.remove(countryId);
//		//proveriti da li postoji zemlja
//		// Country selectOneByName(String countryName)
//		Country country = new Country(1, "Srbija"); 
//		Country result = countryService.add(country);
//
//		Country mima1 = countryService.selectOneByName("Hrvatska");
//		
//		if (Assert.assertTrue(Assert.assertEquals(mima1.getName(), "Srbija"))){
//		//ako postoji obrisati
//			countryService.delete(mima1.getId());
//		}
//		else{
//			log.info("Country "+ mima1.getName() + "does not exist");	
//		}
//	}

	public void updateCountryTest(){
		//countries.set(itemToUpdate.getId(), itemToUpdate);
		Country country = new Country(1,"Srbija");
		Country country1 = new Country(1,"Hrvatska");
		countryService.add(country);
		Country mima1 = countryService.selectOneByName("Srbija");
		Assert.assertEquals(mima1.getName(), "Srbija");
		log.info(mima1.getName() + " is selected");
		
		Country mima2 = countryService.update(country1);
		Assert.assertEquals(mima2.getName(), "Hrvatska");
		
	}

	public void selectOneByIdTest(){
		Country country = new Country(1,"Srbija");
		countryService.add(country);
		Country mima1 = countryService.selectOneById(1);
		Assert.assertEquals(mima1.getId().intValue(), 1);
	}
	
	public void selectAllTest(){
		Country country1 = new Country(1,"Srbija");
		Country country2 = new Country(2,"Hrvatska");
		Country country3 = new Country(3,"Bosna");
		countryService.add(country1);
		countryService.add(country2);
		countryService.add(country3);
		
		List<Country> countries = new ArrayList<Country>();
		countries = countryService.selectAll();
		Assert.assertEquals(countries.size(), 3);
	}
	
	public void clearCountriesTest(){
	//countries.clear();
		Country country = new Country(3,"Bosna");
		countryService.add(country);

		List<Country> countries = new ArrayList<Country>();
		countries = countryService.selectAll();
		Assert.assertEquals(countries.size(), 1);

		countryService.clearAll();
		Assert.assertTrue(countries.isEmpty());
		log.info("List of countries is empty");
	}
	

	//proveriti
	//testAdd nije dobar
//	updateCountryTest - ne valja metoda
//	deleteCountryOkTest
//	deleteCountryNotOkTest
//  selectAllTest kako da ispisem listu
}
