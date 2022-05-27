package com.sebas.taller.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.bussinessDelegate.interfaces.PersonBD;
import com.sebas.taller.model.person.Person;

@Controller
public class PersonControllerImp implements PersonController {

	PersonBD bd;
	
	@Autowired
	public PersonControllerImp(PersonBD bd) {
		this.bd = bd;
	}
	
	@Override
	@GetMapping("/person/addPerson")
	public String addPerson(Model model) {
		model.addAttribute("person", new Person());
		return "person/addPerson";
	}

	@Override
	@GetMapping("/person/delete/{businessentityid}")
	public String deletePerson(@PathVariable("businessentityid") Integer businessentityid, Model model) {
		bd.deletePerson(businessentityid);
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
	public String savePerson( @ModelAttribute Person person, BindingResult bindingResult, Model model, 
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
	@GetMapping("/person/editPerson/{businessentityid}")
	public String showUpdateForm(@PathVariable("businessentityid") Integer businessentityid, Model model) {
		Person person = bd.findPersonById(businessentityid);
		if (person == null)
			throw new IllegalAccessError("Invalid person Id: " + businessentityid);
		model.addAttribute("person", person);
		return "employee/editEmployee";
	}

	@Override
	@PostMapping("/person/editPerson/{businessentityid}")
	public String updatePerson(@PathVariable("businessentityid") Integer businessentityid, @RequestParam(value = "action", required = true) String action,
			@ModelAttribute Person person, BindingResult bindingResult, Model model) {
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
	
	@Override
	@GetMapping("/info/person/{businessentityid}")
	public String showInfoForm(@PathVariable("businessentityid") Integer businessentityid, Model model) {
		Person person = bd.findPersonById(businessentityid);
		model.addAttribute("person", person);
		return "info/person";
	}

}
