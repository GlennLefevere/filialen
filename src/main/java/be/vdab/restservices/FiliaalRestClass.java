package be.vdab.restservices;

import be.vdab.entities.Filiaal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class FiliaalRestClass {
	@SuppressWarnings("unused")
	private long id;
	@SuppressWarnings("unused")
	private String naam;
	public FiliaalRestClass(Filiaal filiaal) {
		this.id = filiaal.getId();
		this.naam = filiaal.getNaam();
	}
	
}
