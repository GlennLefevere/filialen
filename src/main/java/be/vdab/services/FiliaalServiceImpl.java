package be.vdab.services;

import java.math.BigDecimal;
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

	@Override
	public void afwaarderen(Iterable<Long> filiaalIds) {
		List<Filiaal> filialen = filiaalDAO.findAll(filiaalIds);
		for (Filiaal filiaal : filialen) {
			filiaal.setWaardeGebouw(BigDecimal.ZERO);
		}
		filiaalDAO.save(filialen);
	}

}
