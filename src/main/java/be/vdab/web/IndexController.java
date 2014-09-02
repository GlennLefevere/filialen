package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.FiliaalService;

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
}
