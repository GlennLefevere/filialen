package be.vdab.restservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.vdab.entities.Filiaal;
import be.vdab.services.FiliaalService;

@RestController
@RequestMapping("/filialen")
public class FiliaalRestControler {
	@Autowired
	FiliaalService filiaalService;

	@RequestMapping()
	Iterable<FiliaalRestClass> filialen(){
		List<Filiaal> filialen = filiaalService.findAll();
		List<FiliaalRestClass> versturenFilialen = new ArrayList<FiliaalRestClass>();
		for (Filiaal filiaal : filialen) {
			versturenFilialen.add(new FiliaalRestClass(filiaal));
		}
		return versturenFilialen;
	}
}
