package be.vdab.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.FiliaalService;
import be.vdab.valueobjects.FiliaalResponse;

@Controller
@RequestMapping(value="/", produces = MediaType.TEXT_HTML_VALUE)
public class IndexController {
	private static final String VIEW = "/index";
	private static final String REDIRECT_BEVESTIG = "redirect:/bevestigen";
	private static final String BEVESTIG = "bevestiging";
	private final FiliaalService filiaalService;
	
	@Autowired
	public IndexController(FiliaalService filiaalService) {
		this.filiaalService = filiaalService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView weergave(){
		return new ModelAndView(VIEW).addObject("filialen",filiaalService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ModelAndView aanpassen(@RequestBody FiliaalResponse[] filialenids){
		List<Long> filiaalIds = new ArrayList<Long>();
		for (FiliaalResponse filiaalResponse : filialenids) {
			filiaalIds.add(filiaalResponse.getId());
		}
		filiaalService.afwaarderen(filiaalIds);
		return new ModelAndView(REDIRECT_BEVESTIG);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/bevestigen")
	ModelAndView bevestiging(){
		return new ModelAndView(BEVESTIG).addObject("verwijderd", filiaalService.findAll());
	}
}
