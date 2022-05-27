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
import com.sebas.taller.model.person.Countryregion;

@Controller
public class CountryregionControllerImp implements CountryregionController {

	CountryregionBD bd;
	
	@Autowired
	public CountryregionControllerImp(CountryregionBD bd) {
		this.bd = bd;
	}
	
	@Override
	@GetMapping("/countryregion/addCountryregion")
	public String addCountryregion(Model model) {
		model.addAttribute("countryregion", new Countryregion());
//		model.addAttribute("stateprovinces", bd.findAllStateprovince());
		return "countryregion/addCountryregion";
	}

	@Override
	@GetMapping("/countryregion/delete/{countryregionid}")
	public String deleteCountryregion(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		bd.deleteCountryregion(countryregionid);
		return "redirect:/countryregion/";
	}

	@Override
	@GetMapping("/countryregion")
	public String indexCountryregion(Model model) {
		model.addAttribute("countryregions", bd.findAllCountryregion());
		return "countryregion/index";
	}

	@Override
	@PostMapping("/countryregion/addCountryregion")
	public String saveCountryregion(@Validated(Countryregion.Validation.class) @ModelAttribute Countryregion countryregion, BindingResult bindingResult, Model model, 
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
//				model.addAttribute("stateprovinces", bd.findAllStateprovince());
				model.addAttribute("countryregion", countryregion);
				return "countryregion/addCountryregion";
			}
			bd.addCountryregion(countryregion);
		}
		return "redirect:/countryregion/";
	}

	@Override
	@GetMapping("/countryregion/editCountryregion/{countryregionid}")
	public String showUpdateForm(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		Countryregion countryregion = bd.findCountryregionById(countryregionid);
		model.addAttribute("countryregion", countryregion);
//		model.addAttribute("stateprovinces", bd.findAllStateprovince());
		return "countryregion/editCountryregion";
	}

	@Override
	@PostMapping("/countryregion/editCountryregion/{countryregionid}")
	public String updateCountryregion(@PathVariable("countryregionid") Integer countryregionid, @RequestParam(value = "action", required = true) String action, 
			@Validated(Countryregion.Validation.class) @ModelAttribute Countryregion countryregion, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("countryregion", countryregion);
//				model.addAttribute("stateprovinces", bd.findAllStateprovince());
				return "countryregion/editCountryregion";
			}
			bd.updateCountryregion(countryregion);
			model.addAttribute("countryregions", bd.findAllCountryregion());
		}
		return "redirect:/countryregion/";
	}

	@Override
	@GetMapping("/info/countryregion/{countryregionid}")
	public String showInfoForm(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		Countryregion countryregion = bd.findCountryregionById(countryregionid);
		model.addAttribute("countryregion", countryregion);
//		model.addAttribute("stateprovinces", bd.findAllStateprovince());
		return "info/countryregion";
	}

}
