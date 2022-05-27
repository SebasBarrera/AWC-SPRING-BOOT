package com.sebas.taller.controller.hr;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.hr.Employee;

public interface EmployeeController {
	
	public String addEmployee(Model model);

	public String deleteEmployee(@PathVariable("id") Integer id, Model model);

	public String indexEmployee(Model model);

	public String saveEmployee(Employee e, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action);

	public String showUpdateForm(@PathVariable("id") Integer id, Model model);

	public String updateEmployee(@PathVariable("id") Integer id,
			@RequestParam(value = "action", required = true) String action, @ModelAttribute Employee e, BindingResult b, Model model);

	String showInfoForm(Integer countryregionid, Model model);

}
