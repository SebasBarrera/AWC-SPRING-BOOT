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
	public String addCountryregion(Model model) {
		model.addAttribute("countryregion", new Countryregion());
		return "countryregion/addCountryregion";
	}

	@Override
	@GetMapping("/countryregion/delete/{countryregionid}")
	public String deleteCountryregion(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		Countryregion countryregion = cs.findById(countryregionid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid country region Id:" + countryregionid));
		cs.delete(countryregion);
		return "redirect:/countryregion/";
	}

	@Override
	@GetMapping("/countryregion")
	public String indexCountryregion(Model model) {
		model.addAttribute("countryregions", cs.findAll());
		return "countryregion/index";
	}

	@Override
	@PostMapping("/countryregion/add")
	public String saveCountryregion(@Validated @ModelAttribute Countryregion countryregion, BindingResult bindingResult, Model model, 
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("countryregion", countryregion);
				return "countryregion/add";
			}
			cs.save(countryregion);
		}
		return "redirect:/countryregion/";
	}

	@Override
	@GetMapping("/countryregion/edit/{countryregionid}")
	public String showUpdateForm(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		Countryregion countryregion = cs.findById(countryregionid).orElseThrow(() -> new IllegalArgumentException("Invalid country region Id:" + countryregionid));
		model.addAttribute("countryregion", countryregion);
		return "countryregion/updateCountryregion";
	}

	@Override
	@PostMapping("/countryregion/edit/{countryregionid}")
	public String updateCountryregion(@PathVariable("countryregionid") Integer countryregionid, @RequestParam(value = "action", required = true) String action, 
			@Validated @ModelAttribute Countryregion countryregion, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("countryregion", countryregion);
				return "countryregion/updateCountryregion";
			}
			cs.save(countryregion);
			model.addAttribute("countryregions", cs.findAll());
		}
		return "redirect:/countryregion/";
	}



}
