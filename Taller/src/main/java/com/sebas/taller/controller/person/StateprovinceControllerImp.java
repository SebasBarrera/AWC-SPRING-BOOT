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

import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.service.person.CountryregionService;
import com.sebas.taller.service.person.StateprovinceService;
import com.sebas.taller.service.sales.SalesterritoryService;

@Controller
public class StateprovinceControllerImp implements StateprovinceController {

	StateprovinceService ss;
	CountryregionService cs;
	SalesterritoryService ts;
	
	@Autowired
	public StateprovinceControllerImp(SalesterritoryService ts, StateprovinceService ss, CountryregionService cs) {
		this.ss = ss;
		this.ts = ts;
		this.cs = cs;
	}
	
	@Override
	@GetMapping("/stateprovince/addStateprovince")
	public String addStateProvince(Model model) {
		model.addAttribute("stateprovince", new Stateprovince());
		
		model.addAttribute("territoryids", ts.findAll());
		model.addAttribute("countryregions", cs.findAll());
		return "stateprovince/addStateprovince";
	}

	@Override
	@GetMapping("/stateprovince/delete/{stateprovinceid}")
	public String deleteStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		Stateprovince stateprovince = ss.findById(stateprovinceid);
		ss.delete(stateprovince);
		model.addAttribute("stateprovinces", ss.findAll());
		return "stateprovince/index";
	}

	@Override
	@GetMapping("/stateprovince/")
	public String indexStateProvince(Model model) {
		model.addAttribute("stateprovinces", ss.findAll());
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
				model.addAttribute("countryregions", cs.findAll());
				return "stateprovince/addStateprovince";
			}
			ss.save(stateprovince);
		}
		return "redirect:/stateprovince/";
	}

	@Override
	@GetMapping("/stateprovince/editStateprovince/{stateprovinceid}")
	public String showUpdateForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		Stateprovince stateprovince = ss.findById(stateprovinceid);
		if (stateprovince == null) 
			throw new IllegalArgumentException("Invalid state province id: " + stateprovinceid);
		model.addAttribute("stateprovince", stateprovince);
		model.addAttribute("territoryids", ts.findAll());
		model.addAttribute("countryregions", cs.findAll());
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
				model.addAttribute("countryregions", cs.findAll());
				return "stateprovince/editStateprovince";
			}
			ss.save(stateprovince);
			model.addAttribute("stateprovinces", ss.findAll());
		}
		return "redirect:/stateprovince/";
	}
	
	@Override
	@GetMapping("/info/stateprovince/{stateprovinceid}")
	public String showInfoForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		Stateprovince stateprovince = ss.findById(stateprovinceid);
		if (stateprovince == null) 
			throw new IllegalArgumentException("Invalid state province id: " + stateprovinceid);
		model.addAttribute("stateprovince", stateprovince);
		model.addAttribute("territoryids", ts.findAll());
		model.addAttribute("countryregions", cs.findAll());
		return "info/stateprovince";
	}

}
