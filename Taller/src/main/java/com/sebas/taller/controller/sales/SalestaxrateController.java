package com.sebas.taller.controller.sales;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.sales.Salestaxrate;

public interface SalestaxrateController {
	
	public String addSalestaxrate(Model model, @ModelAttribute("salestaxrate") Salestaxrate t);

	public String deleteSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model);

	public String indexSalestaxrate(Model model);

	public String saveSalestaxrate(Salestaxrate t, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("salestaxrateid") Integer salestaxrateid, Model model);

	public String updateSalestaxrate(@PathVariable("salestaxrateid") Integer salestaxrateid,
			@RequestParam(value = "action", required = true) String action, Salestaxrate t, Model model);
}
