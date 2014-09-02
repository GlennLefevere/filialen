package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.dao.FiliaalDAO;
import be.vdab.entities.Filiaal;

@Service
public class FiliaalServiceImpl implements FiliaalService{
	private final FiliaalDAO filiaalDAO;
	
	@Autowired
	public FiliaalServiceImpl(FiliaalDAO filiaalDAO) {
		this.filiaalDAO = filiaalDAO;
	}

	@Override
	public List<Filiaal> findAll() {
		return filiaalDAO.findAll();
	}

}
