package com.sebas.taller.controller.sales;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.sales.Salestaxrate;

public interface SalestaxrateController {
	
	public String addUser(Model model, @ModelAttribute("salestaxrate") Salestaxrate t);

	public String deleteUser(@PathVariable("id") Integer salestaxrateid, Model model);

	public String indexUser(Model model);

	public String saveUser(Salestaxrate t, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("id") Integer salestaxrateid, Model model);

	public String updateUser(@PathVariable("salestaxrateid") Integer salestaxrateid,
			@RequestParam(value = "action", required = true) String action, Salestaxrate t, Model model);
}
