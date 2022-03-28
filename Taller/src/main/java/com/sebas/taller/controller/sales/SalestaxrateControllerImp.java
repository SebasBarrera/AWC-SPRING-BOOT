package com.sebas.taller.controller.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.service.sales.SalestaxrateService;

public class SalestaxrateControllerImp implements SalestaxrateController {

	SalestaxrateService ts;
	
	@Autowired
	public SalestaxrateControllerImp(SalestaxrateService ts) {
		this.ts = ts;
	}
	
	@Override
	@GetMapping("/salestaxrate/add")
	public String addSalestaxrate(Model model, @ModelAttribute("salestaxrate") Salestaxrate t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/salestaxrate/delete/{addressid}")
	public String deleteSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/salestaxrate/")
	public String indexSalestaxrate(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/salestaxrate/add")
	public String saveSalestaxrate(Salestaxrate t, @RequestParam(value = "action", required = true) String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/salestaxrate/edit/{salestaxrateid}")
	public String showUpdateForm(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/salestaxrate/edit/{salestaxrate}")
	public String updateSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, @RequestParam(value = "action", required = true) String action, Salestaxrate t, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
