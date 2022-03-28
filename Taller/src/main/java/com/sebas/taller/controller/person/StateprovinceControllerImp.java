package com.sebas.taller.controller.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Stateprovince;

@Controller
public class StateprovinceControllerImp implements StateprovinceController {

	@Override
	public String addUser(Model model, @ModelAttribute("stateprovince") Stateprovince s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String indexUser(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveUser(Stateprovince s, @RequestParam(value = "action", required = true) String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showUpdateForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(@PathVariable("stateprovinceid") Integer stateprovinceid, @RequestParam(value = "action", required = true) String action, Stateprovince s, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
