package com.sebas.taller.controller.sales;


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

import com.sebas.taller.bussinessDelegate.interfaces.SalestaxrateBD;
import com.sebas.taller.bussinessDelegate.interfaces.StateprovinceBD;
import com.sebas.taller.model.sales.Salestaxrate;

@Controller
public class SalestaxrateControllerImp implements SalestaxrateController {

	
	SalestaxrateBD bd;
	StateprovinceBD sbd;

	@Autowired
	public SalestaxrateControllerImp(SalestaxrateBD bd, StateprovinceBD sbd) {
		this.bd = bd;
		this.sbd = sbd;
	}
	
	@Override
	@GetMapping("/salestaxrate/addSalestaxrate")
	public String addSalestaxrate(Model model) {
		model.addAttribute("salestaxrate", new Salestaxrate());
		
		model.addAttribute("stateprovinces", sbd.findAllStateprovince());
		return "salestaxrate/addSalestaxrate";
	}

	@Override
	@GetMapping("/salestaxrate/delete/{salestaxrateid}")
	public String deleteSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model) {
//		Salestaxrate salestaxrate = bd.findSalestaxrateById(salestaxrateid);
		bd.deleteSalestaxrate(salestaxrateid);
		model.addAttribute("salestaxrates", bd.findAllSalestaxrate());
		return "salestaxrate/index";
	}

	@Override
	@GetMapping("/salestaxrate/")
	public String indexSalestaxrate(Model model) {
		model.addAttribute("salestaxrates", bd.findAllSalestaxrate());
		return "salestaxrate/index";
	}

	@Override
	@PostMapping("/salestaxrate/addSalestaxrate")
	public String saveSalestaxrate(@Validated(Salestaxrate.Validation.class) @ModelAttribute Salestaxrate salestaxrate, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("salestaxrate", salestaxrate);
				model.addAttribute("stateprovinces", sbd.findAllStateprovince());
				return "salestaxrate/addSalestaxrate";
			}
			bd.addSalestaxrate(salestaxrate);
//			ts.save(salestaxrate);
		}
		return "redirect:/salestaxrate/";
	}

	@Override
	@GetMapping("/salestaxrate/editSalestaxrate/{salestaxrateid}")
	public String showUpdateForm(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model) {
		Salestaxrate salestaxrate = bd.findSalestaxrateById(salestaxrateid);
		if (salestaxrate == null)
			throw new IllegalArgumentException("Invalid salestaxrate id: " + salestaxrateid);
		model.addAttribute("salestaxrate", salestaxrate);
		model.addAttribute("stateprovinces", sbd.findAllStateprovince());
		return "salestaxrate/editSalestaxrate";
	}

	@Override
	@PostMapping("/salestaxrate/editSalestaxrate/{salestaxrateid}")
	public String updateSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, @RequestParam(value = "action", required = true) String action, 
			@Validated(Salestaxrate.Validation.class) @ModelAttribute Salestaxrate salestaxrate, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("salestaxrate", salestaxrate);
				model.addAttribute("stateprovinces", sbd.findAllStateprovince());
				return "salestaxrate/editSalestaxrate";
			}
			bd.updateSalestaxrate(salestaxrate);
//			ts.update(salestaxrate);
			model.addAttribute("salestaxrates", bd.findAllSalestaxrate());
		}
		
		return "redirect:/salestaxrate/";
	}

}
