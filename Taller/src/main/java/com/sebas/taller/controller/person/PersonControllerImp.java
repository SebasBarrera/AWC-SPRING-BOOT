package com.sebas.taller.controller.person;

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

import com.sebas.taller.bussinessDelegate.BusinessDelegate;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Person;

@Controller
public class PersonControllerImp implements PersonController {

	BusinessDelegate bd;
	
	@Autowired
	public PersonControllerImp(BusinessDelegate bd) {
		this.bd = bd;
	}
	
	@Override
	@GetMapping("/person/addPerson")
	public String addPerson(Model model) {
		model.addAttribute("person", new Person());
		return "person/addPerson";
	}

	@Override
	@GetMapping("/person/delete/{personid}")
	public String deletePerson(@PathVariable("personid") Integer personid, Model model) {
		bd.deletePerson(personid);
		model.addAttribute("persons", bd.findAllPerson());
		return "person/index";
	}

	@Override
	@GetMapping("/person/")
	public String indexPerson(Model model) {
		model.addAttribute("persons", bd.findAllPerson());
		return "person/index";
	}

	@Override
	@PostMapping("/person/addPerson")
	public String savePerson(@Validated(Address.Validation.class) @ModelAttribute Person person, BindingResult bindingResult, Model model, 
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("person", person);
				return "person/addPerson";
			}
			bd.addPerson(person);
		}
		return "redirect:/person/";
	}

	@Override
	@GetMapping("/person/editPerson/{personid}")
	public String showUpdateForm(@PathVariable("personid") Integer personid, Model model) {
		Person person = bd.findPersonById(personid);
		return null;
	}

	@Override
	@PostMapping("/person/editPerson/{personid}")
	public String updatePerson(@PathVariable("personid") Integer personid, @RequestParam(value = "action", required = true) String action,
			@Validated(Address.Validation.class) @ModelAttribute Person person, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("person", person);
				return "person/editPerson";
			}
			bd.updatePerson(person);
			model.addAttribute("persons", bd.findAllPerson());
		}
		return "redirect:/person/";
	}

}
