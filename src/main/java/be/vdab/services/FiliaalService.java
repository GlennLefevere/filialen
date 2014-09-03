package be.vdab.services;

import java.util.List;

import be.vdab.entities.Filiaal;

public interface FiliaalService {
	public List<Filiaal> findAll();
	public List<Filiaal> findByIdIn(Iterable<Long> filiaalIds);
	public void save(Iterable<Filiaal> filialen);
}
