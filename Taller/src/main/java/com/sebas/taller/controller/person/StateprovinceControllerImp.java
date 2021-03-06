package com.sebas.taller.controller.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.bussinessDelegate.interfaces.CountryregionBD;
import com.sebas.taller.bussinessDelegate.interfaces.StateprovinceBD;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.service.sales.SalesterritoryService;

@Controller
public class StateprovinceControllerImp implements StateprovinceController {

	StateprovinceBD bd;
	SalesterritoryService ts;
	CountryregionBD cbd;
	
	
	@Autowired
	public StateprovinceControllerImp(StateprovinceBD bd, SalesterritoryService ts, CountryregionBD cbd) {
		this.bd = bd;
		this.ts = ts;
		this.cbd = cbd;
	}
	
	@Override
	@GetMapping("/stateprovince/addStateprovince")
	public String addStateProvince(Model model) {
		model.addAttribute("stateprovince", new Stateprovince());
		
		model.addAttribute("territoryids", ts.findAll());
		model.addAttribute("countryregions", cbd.findAllCountryregion());
		return "stateprovince/addStateprovince";
	}

	@Override
	@GetMapping("/stateprovince/delete/{stateprovinceid}")
	public String deleteStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
//		Stateprovince stateprovince = bd.findStateprovinceById(stateprovinceid);
		bd.deleteStateprovince(stateprovinceid);
		model.addAttribute("stateprovinces", bd.findAllStateprovince());
		return "stateprovince/index";
	}

	@Override
	@GetMapping("/stateprovince/")
	public String indexStateProvince(Model model) {
		model.addAttribute("stateprovinces", bd.findAllStateprovince());
		return "stateprovince/index";
	}

	@Override
	@PostMapping("/stateprovince/addStateprovince")
	public String saveStateProvince(@Validated(Stateprovince.Validation.class) @ModelAttribute Stateprovince stateprovince, BindingResult bindingResult, Model model, 
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel") ) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("stateprovince", stateprovince);
				model.addAttribute("territoryids", ts.findAll());
				model.addAttribute("countryregions", cbd.findAllCountryregion());
				return "stateprovince/addStateprovince";
			}
			bd.addStateprovince(stateprovince);
		}
		return "redirect:/stateprovince/";
	}

	@Override
	@GetMapping("/stateprovince/editStateprovince/{stateprovinceid}")
	public String showUpdateForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		Stateprovince stateprovince = bd.findStateprovinceById(stateprovinceid);
		if (stateprovince == null) 
			throw new IllegalArgumentException("Invalid state province id: " + stateprovinceid);
		model.addAttribute("stateprovince", stateprovince);
		model.addAttribute("territoryids", ts.findAll());
		model.addAttribute("countryregions", cbd.findAllCountryregion());
		return "stateprovince/editStateprovince";
	}

	@Override
	@PostMapping("/stateprovince/editStateprovince/{stateprovinceid}")
	public String updateStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid, @RequestParam(value = "action", required = true) String action, 
			@Validated(Stateprovince.Validation.class) @ModelAttribute Stateprovince stateprovince, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("stateprovince", stateprovince);
				model.addAttribute("territoryids", ts.findAll());
				model.addAttribute("countryregions", cbd.findAllCountryregion());
				return "stateprovince/editStateprovince";
			}
			bd.updateStateprovince(stateprovince);
			model.addAttribute("stateprovinces", bd.findAllStateprovince());
		}
		return "redirect:/stateprovince/";
	}
	
	@Override
	@GetMapping("/info/stateprovince/{stateprovinceid}")
	public String showInfoForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		Stateprovince stateprovince = bd.findStateprovinceById(stateprovinceid);
		if (stateprovince == null) 
			throw new IllegalArgumentException("Invalid state province id: " + stateprovinceid);
		model.addAttribute("stateprovince", stateprovince);
		model.addAttribute("territoryids", ts.findAll());
		model.addAttribute("countryregions", cbd.findAllCountryregion());
		return "info/stateprovince";
	}

}
