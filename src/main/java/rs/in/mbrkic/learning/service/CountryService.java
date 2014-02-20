package rs.in.mbrkic.learning.service;

import java.util.List;

import rs.in.mbrkic.learning.model.Country;

public interface CountryService {
	
	/**
	 * uzeti u obzir da ne sme da bude country da dupliranim imenom
	 * @param country
	 * @return
	 */
	Country add(Country country);
	
	/**
	 * trebaju jos metode za 
	 * 2. brisanje country
	 * 3. update country
	 * 4. dobavi jedan country po id
	 * 5. dobavi jedan country po name
	 * 6. dobavi sve country-ije 
	 */

	//brisanje
	void delete(Integer countryId);
	
	//update 
	Country update(Country itemToUpdate);
	
	//dobavi jedan country po id
	Country selectOneById(Integer countryId);
	
	//dobavi jedan country po name
	Country selectOneByName(String countryName);
	
	//dobavi sve country-ije
	List<Country> selectAll();
	
	void clearAll();

}
