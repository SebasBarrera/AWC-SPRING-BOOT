package com.sebas.taller.controller.sales;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.sales.Salestaxrate;

public class SalestaxrateControllerImp implements SalestaxrateController {

	@Override
	public String addUser(Model model, @ModelAttribute("salestaxrate") Salestaxrate t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(@PathVariable("id") Integer salestaxrateid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String indexUser(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveUser(Salestaxrate t, @RequestParam(value = "action", required = true) String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showUpdateForm(@PathVariable("id") Integer salestaxrateid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(@PathVariable("id") Integer salestaxrateid, @RequestParam(value = "action", required = true) String action, Salestaxrate t, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
