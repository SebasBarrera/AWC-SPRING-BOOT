package com.sebas.taller.controller.sales;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
public class SalestaxrateControllerImp implements SalestaxrateController {

	SalestaxrateService ts;
	StateprovinceService ss;
	
	@Autowired
	public SalestaxrateControllerImp(SalestaxrateService ts, StateprovinceService ss) {
		this.ts = ts;
		this.ss = ss;
	}
	
	@Override
	@GetMapping("/salestaxrate/addSalestaxrate")
	public String addSalestaxrate(Model model) {
		model.addAttribute("salestaxrate", new Salestaxrate());
		
		model.addAttribute("stateprovinces", ss.findAll());
		return "salestaxrate/addSalestaxrate";
	}

	@Override
	@GetMapping("/salestaxrate/delete/{addressid}")
	public String deleteSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model) {
		Salestaxrate salestaxrate = ts.findById(salestaxrateid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid tax rate id: " + salestaxrateid));
		ts.delete(salestaxrate);
		model.addAttribute("salestaxrates", ts.findAll());
		return "salestaxrate/index";
	}

	@Override
	@GetMapping("/salestaxrate/")
	public String indexSalestaxrate(Model model) {
		model.addAttribute("salestaxrates", ts.findAll());
		return "salestaxrate/index";
	}

	@Override
	@PostMapping("/salestaxrate/addSalestaxrate")
	public String saveSalestaxrate(@Validated @ModelAttribute Salestaxrate salestaxrate, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("salestaxrate", salestaxrate);
				model.addAttribute("stateprovinces", ss.findAll());
				return "salestaxrate/addSalestaxrate";
			}
			ts.save(salestaxrate);
		}
		return "redirect:/salestaxrate/";
	}

	@Override
	@GetMapping("/salestaxrate/editSalestaxrate/{salestaxrateid}")
	public String showUpdateForm(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model) {
		Optional<Salestaxrate> salestaxrate = ts.findById(salestaxrateid);
		if (salestaxrate == null)
			throw new IllegalArgumentException("Invalid salestaxrate id: " + salestaxrateid);
		model.addAttribute("salestaxrate", salestaxrate.get());
		model.addAttribute("stateprovinces", ss.findAll());
		return "salestaxrate/editSalestaxrate";
	}

	@Override
	@PostMapping("/salestaxrate/editSalestaxrate/{salestaxrate}")
	public String updateSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, @RequestParam(value = "action", required = true) String action, 
			@Validated @ModelAttribute Salestaxrate salestaxrate, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("salestaxrate", salestaxrate);
				model.addAttribute("stateprovinces", ss.findAll());
				return "salestaxrate/editSalestaxrate";
			}
			ts.save(salestaxrate);
			model.addAttribute("salestaxrates", ts.findAll());
		}
		
		return "redirect:/salestaxrate/";
	}

}
