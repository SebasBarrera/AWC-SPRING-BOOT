package com.sebas.taller.controller.hr;

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
import com.sebas.taller.model.hr.Employee;
import com.sebas.taller.model.person.Address;

@Controller
public class EmployeeControllerImp implements EmployeeController {

	BusinessDelegate bd;
	
	@Autowired
	public EmployeeControllerImp(BusinessDelegate bd) {
		this.bd = bd;
	}
	
	@Override
	@GetMapping("/employee/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/addEmployee";
	}

	@Override
	@GetMapping("/employee/delete/{employeeid}")
	public String deleteEmployee(Integer employeeid, Model model) {
		bd.deleteEmployee(employeeid);
		model.addAttribute("employees", bd.findAllEmployee());
		return "employee/index";
	}

	@Override
	@PostMapping("/employee/")
	public String indexEmployee(Model model) {
		model.addAttribute("employees", bd.findAllEmployee());
		return "employee/index";
	}

	@Override
	@PostMapping("/employee/addEmployee")
	public String saveEmployee(@Validated(Address.Validation.class) @ModelAttribute Employee employee, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("employee", employee);
				return "employee/addEmployee";
			}
			bd.addEmployee(employee);
		}
		return "redirect:/employee/";
	}

	@Override
	@PostMapping("/empoyee/editEmployee/{employeeid}")
	public String showUpdateForm(@PathVariable("employeeid") Integer employeeid, Model model) {
		Employee employee = bd.findEmployeeById(employeeid);
		if (employee == null) 
			throw new IllegalArgumentException("Invalid employee Id: " + employeeid);
		model.addAttribute("employee", employee);
		return "employee/editEmployee";
	}

	@Override
	@PostMapping("/employee/editEmployee/{employeeid}")
	public String updateEmployee(@PathVariable("employeeid") Integer employeeid, @RequestParam(value = "action", required = true) String action, 
			@Validated(Address.Validation.class) @ModelAttribute Employee employee, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("employee", employee);
				return "employee/editEmployee";
			}
			bd.updateEmployee(employee);
			model.addAttribute("employees", bd.findAllEmployee());
		}
		return "redirect:/employee/";
	}
	
	

}
