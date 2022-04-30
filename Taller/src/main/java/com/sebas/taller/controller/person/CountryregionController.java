package com.sebas.taller.controller.person;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Countryregion;


public interface CountryregionController {
	
	public String addCountryregion(Model model);

	public String deleteCountryregion(@PathVariable("countryregionid") Integer countryregionid, Model model);

	public String indexCountryregion(Model model);

	public String saveCountryregion(Countryregion c, BindingResult b, Model model, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("countryregionid") Integer countryregionid, Model model);

	public String updateCountryregion(@PathVariable("countryregionid") Integer countryregionid,
			@RequestParam(value = "action", required = true) String action, Countryregion c, BindingResult b, Model model);

	String showInfoForm(Integer countryregionid, Model model);
}


