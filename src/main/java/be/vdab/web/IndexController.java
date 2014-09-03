package be.vdab.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Filiaal;
import be.vdab.services.FiliaalService;
import be.vdab.valueobjects.FiliaalResponse;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final String VIEW = "/index";
	private final FiliaalService filiaalService;
	
	@Autowired
	public IndexController(FiliaalService filiaalService) {
		this.filiaalService = filiaalService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView weergave(){
		return new ModelAndView(VIEW).addObject("filialen",filiaalService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "afwaarderen")
	ModelAndView aanpassen(@RequestBody FiliaalResponse[] filialenids){
		List<Long> filiaalIds = new ArrayList<Long>();
		for (FiliaalResponse filiaalResponse : filialenids) {
			filiaalIds.add(filiaalResponse.getId());
		}
		List<Filiaal> filialen = filiaalService.findByIdIn(filiaalIds);
		for (Filiaal filiaal : filialen) {
			filiaal.setWaardeGebouw(BigDecimal.ZERO);
		}
		filiaalService.save(filialen);
		return null;
	}
}
