package com.sebas.taller.controller.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Countryregion;

@Controller
public class CountryregionControllerImp implements CountryregionController {

	@Override
	public String addUser(@ModelAttribute("countryregion") Model model, Countryregion c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String indexUser(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveUser(Countryregion c, @RequestParam(value = "action", required = true) String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showUpdateForm(@PathVariable("countryregionid") Integer countryregionid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(@PathVariable("countryregionid") Integer countryregionid, @RequestParam(value = "action", required = true) String action, Countryregion c, Model model) {
		// TODO Auto-generated method stub
		return null;
	}



}
