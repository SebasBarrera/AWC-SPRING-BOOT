package com.sebas.taller.controller.person;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Address;

public interface AddressController {
	
	public String addAddress(Model model, @ModelAttribute("address") Address a);

	public String deleteAddress(@PathVariable("id") Integer id, Model model);

	public String indexAddress(Model model);

	public String saveAddress(Address a, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("id") Integer id, Model model);

	public String updateAddress(@PathVariable("id") Integer id,
			@RequestParam(value = "action", required = true) String action, @ModelAttribute Address a, Model model);

	public String login(Model model);
}



