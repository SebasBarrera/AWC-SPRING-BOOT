package com.sebas.taller.controller.person;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Stateprovince;

public interface StateprovinceController {
	
	public String addStateProvince(Model model);

	public String deleteStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model);

	public String indexStateProvince(Model model);

	public String saveStateProvince(Stateprovince s, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("stateprovinceid") Integer stateprovinceid, Model model);

	public String updateStateProvince(@PathVariable("stateprovinceid") Integer stateprovinceid,
			@RequestParam(value = "action", required = true) String action, Stateprovince s, BindingResult b, Model model);
}
