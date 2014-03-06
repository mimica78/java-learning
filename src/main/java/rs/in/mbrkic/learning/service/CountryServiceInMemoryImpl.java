/**
 * 
 */
package rs.in.mbrkic.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import rs.in.mbrkic.learning.model.Country;

/**
 * @author m.brkic
 *
 */
public class CountryServiceInMemoryImpl implements CountryService {
	
	private static final Logger log = Logger.getLogger(CountryServiceInMemoryImpl.class);
	
	private List<Country> countries = new ArrayList<Country>();
	
	/**
	 * 
	public CountryServiceInMemoryImpl() {
		countries = new ArrayList<Country>();
	}
	**/
	
	/**
	 * uzeti u obzir da ne sme da bude country da dupliranim imenom
	 */
	public Country add(Country country) {
		// ovo je jednostavno resenje bez da uzme u obzir zahtev
		// countries.add(country);
		// a teba nam resenje koje ce da onemoguci dodvanje u listu 
		// ako country sa takvim imenom vec postoji
		/**
		if (!countries.isEmpty()) {
			for (Country item : countries) {
				System.out.println("Country name: " + item.getName());
				if (country.getName().equals(item.getName())) {
					// nemoj da radis nista
				} else {
					countries.add(country);
				}
			}
		} else {
			countries.add(country);
		}
		**/
		if (!countries.contains(country)) {
			countries.add(country);
			log.info("Dodala sam country u listu sa id: " + country.getId());
		} 
		return country;
	}
	

	public void delete(Integer countryId) {
		// countries.remove(countryId);

		Country countryToDelete = null;
		
		for (Country item: countries) {
			if (item.getId().equals(countryId)) {
				countryToDelete = item;
				break;
			}
		}
		
		if (countryToDelete != null) {
			countries.remove(countryToDelete);
		}
	}
	
	public Country update(Country itemToUpdate) {
//		countries.set(itemToUpdate.getId() - 1, itemToUpdate);
//		return itemToUpdate;
		
		for (Country item: countries) {
			if (item.getId().equals(itemToUpdate.getId())) {
				item.setName(itemToUpdate.getName());
			}
		}
		
		return itemToUpdate;
	}

	public Country selectOneById(Integer countryId) {
		// return countries.get(countryId);
		
		for (Country item: countries) {
			System.out.println("Country id:" + item.getId() + "; countryName: " + item.getName());
			if (item.getId().equals(countryId)) {
				return item;
			}
		}
		return null;
	}

	public Country selectOneByName(String countryName) {
		// return countries.get(countryName);
		for (Country item : countries) {
			System.out.println("Country name:" + item.getName());
			if (item.getName().equals(countryName)){
				return item;
			}
		}
		return null;
	}

	public List<Country> selectAll() {
		/**
		List<Country> result = new ArrayList<Country>();
		for (Integer key : (Country countries).keySet()) {
			Country country = countries.get(key);
			result.add(country);
		}
		return result;
		**/
		// List<Country> result = new ArrayList<Country>();
		return countries;
	}

	public void clearAll() {
		countries.clear();
	}
	

}
