package rs.in.mbrkic.learning.main;

import rs.in.mbrkic.learning.model.Country;
import rs.in.mbrkic.learning.service.CountryServiceInMemoryImpl;

public class MimaGlavnaKlasa {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountryServiceInMemoryImpl test = new CountryServiceInMemoryImpl();
		Country country = new Country(1, "Srbija");
		
		Country result = test.add(country);
		
		System.out.print(result.getName());
		

	}

}
