package com.sebas.taller.controller.person;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Stateprovince;

public interface StateprovinceController {
	
	public String addStateProvince(Model model, @ModelAttribute("stateprovince") Stateprovince s);

	public String deleteStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model);

	public String indexStateProvince(Model model);

	public String saveStateProvince(Stateprovince s, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model);

	public String updateStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid,
			@RequestParam(value = "action", required = true) String action, Stateprovince s, Model model);
}
