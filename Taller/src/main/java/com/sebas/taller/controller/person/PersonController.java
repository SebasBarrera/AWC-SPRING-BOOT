package com.sebas.taller.controller.person;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Person;

public interface PersonController {
	
	public String addPerson(Model model);

	public String deletePerson(@PathVariable("id") Integer id, Model model);

	public String indexPerson(Model model);

	public String savePerson(Person p, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("id") Integer id, Model model);

	public String updatePerson(@PathVariable("id") Integer id,
			@RequestParam(value = "action", required = true) String action, @ModelAttribute Person p, BindingResult b, Model model);

}