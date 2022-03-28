package com.sebas.taller.controller.person;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Countryregion;

public interface CountryregionController {
	
	public String addUser(Model model, @ModelAttribute("countryregion") Countryregion c);

	public String deleteUser(@PathVariable("id") long id, Model model);

	public String indexUser(Model model);

	public String saveUser(Countryregion c, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("id") long id, Model model);

	public String updateUser(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, Countryregion c, Model model);
}


