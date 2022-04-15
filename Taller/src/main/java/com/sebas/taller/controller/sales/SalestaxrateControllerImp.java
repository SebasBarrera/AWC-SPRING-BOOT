package com.sebas.taller.controller.sales;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.service.person.StateprovinceService;
import com.sebas.taller.service.sales.SalestaxrateService;

public class SalestaxrateControllerImp implements SalestaxrateController {

	SalestaxrateService ts;
	StateprovinceService ss;
	
	@Autowired
	public SalestaxrateControllerImp(SalestaxrateService ts, StateprovinceService ss) {
		this.ts = ts;
		this.ss = ss;
	}
	
	@Override
	@GetMapping("/salestaxrate/add")
	public String addSalestaxrate(Model model) {
		model.addAttribute("taxrate", new Salestaxrate());
		
		model.addAttribute("stateprovinces", ss.findAll());
		return "salestaxrate/addSalestaxrate";
	}

	@Override
	@GetMapping("/salestaxrate/delete/{addressid}")
	public String deleteSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model) {
		Salestaxrate taxrate = ts.findById(salestaxrateid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid tax rate id: " + salestaxrateid));
		ts.delete(taxrate);
		model.addAttribute("taxrates", ts.findAll());
		return "salestaxrate/index";
	}

	@Override
	@GetMapping("/salestaxrate/")
	public String indexSalestaxrate(Model model) {
		model.addAttribute("taxrates", ts.findAll());
		return "salestaxrate/index";
	}

	@Override
	@PostMapping("/salestaxrate/add")
	public String saveSalestaxrate(@Validated @ModelAttribute Salestaxrate taxrate, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("taxrate", taxrate);
				model.addAttribute("stateprovinces", ss.findAll());
				return "salestaxrate/addSalestaxrate";
			}
			ts.save(taxrate);
		}
		return "redirect:/salestaxrate/";
	}

	@Override
	@GetMapping("/salestaxrate/edit/{salestaxrateid}")
	public String showUpdateForm(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model) {
		Optional<Salestaxrate> taxrate = ts.findById(salestaxrateid);
		if (taxrate == null)
			throw new IllegalArgumentException("Invalid taxrate id: " + salestaxrateid);
		model.addAttribute("taxrate", taxrate.get());
		model.addAttribute("stateprovinces", ts.findAll());
		return "salestaxrate/updateSalestaxrate";
	}

	@Override
	@PostMapping("/salestaxrate/edit/{salestaxrate}")
	public String updateSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, @RequestParam(value = "action", required = true) String action, 
			@Validated @ModelAttribute Salestaxrate taxrate, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("taxrate", taxrate);
				model.addAttribute("stateprovinces", ss.findAll());
			}
			ts.save(taxrate);
			model.addAttribute("taxrates", ts.findAll());
		}
		
		return "redirect:/salestaxrate/";
	}

}
