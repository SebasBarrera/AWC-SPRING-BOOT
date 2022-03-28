package com.sebas.taller.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.service.person.StateprovinceService;

@Controller
public class StateprovinceControllerImp implements StateprovinceController {

	StateprovinceService ss;
	
	@Autowired
	public StateprovinceControllerImp(StateprovinceService ss) {
		this.ss = ss;
	}
	
	@Override
	@GetMapping("/stateprovince/add")
	public String addStateProvince(Model model, @ModelAttribute("stateprovince") Stateprovince s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/stateprovince/delete/{stateprovinceid}")
	public String deleteStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/stateprovince/")
	public String indexStateProvince(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/stateprovince/add")
	public String saveStateProvince(Stateprovince s, @RequestParam(value = "action", required = true) String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/stateprovince/edit/{stateprovinceid}")
	public String showUpdateForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/stateprovince/edit/{stateprovinceid}")
	public String updateStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid, @RequestParam(value = "action", required = true) String action, Stateprovince s, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
