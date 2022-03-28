package com.sebas.taller.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.service.person.CountryregionService;

@Controller
public class CountryregionControllerImp implements CountryregionController {

	CountryregionService cs;
	
	@Autowired
	public CountryregionControllerImp(CountryregionService cs) {
		this.cs = cs;
	}
	
	@Override
	@GetMapping("/countryregion/add")
	public String addCountryregion(@ModelAttribute("countryregion") Model model, Countryregion c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/countryregion/delete/{countryregionid}")
	public String deleteCountryregion(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/countryregion")
	public String indexCountryregion(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/countryregion/add")
	public String saveCountryregion(Countryregion c, @RequestParam(value = "action", required = true) String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/countryregion/edit/{countryregionid}")
	public String showUpdateForm(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/countryregion/edit/{countryregionid}")
	public String updateCountryregion(@PathVariable("countryregionid") Integer countryregionid, @RequestParam(value = "action", required = true) String action, Countryregion c, Model model) {
		// TODO Auto-generated method stub
		return null;
	}



}
