package com.sebas.taller.controller.person;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Stateprovince;

public interface StateprovinceController {
	
	public String addUser(Model model, @ModelAttribute("stateprovince") Stateprovince s);

	public String deleteUser(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model);

	public String indexUser(Model model);

	public String saveUser(Stateprovince s, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model);

	public String updateUser(@PathVariable("stateprovinceid") Integer stateprovinceid,
			@RequestParam(value = "action", required = true) String action, Stateprovince s, Model model);
}
