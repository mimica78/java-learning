package rs.in.mbrkic.learning.model;

public class Country {
	
	//~ private
	private Integer id;
	private String name;
	
	public Country() {
		
	}
	
	public Country(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNameWithArgument(String argument) throws IllegalArgumentException {
		if (argument == null) {
			throw new IllegalArgumentException("Argument must be provided!");
		} else {
			if (argument.equals("Hrvoje")) {
				return "Hrvatska";
			} else if (argument.equals("Miloje")) {
				return "Srbija";
			} else {
				return "Makedonija";
			}
		}
	}

	
	@Override
	public String toString() {
		return "Country: [id: " + this.id + ", name: " + this.name + "]";
	}
	
	

}
