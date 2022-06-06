package com.sebas.taller.controller.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.bussinessDelegate.interfaces.EmployeeBD;
import com.sebas.taller.model.hr.Employee;

@Controller
public class EmployeeControllerImp implements EmployeeController {

	EmployeeBD bd;
	
	@Autowired
	public EmployeeControllerImp(EmployeeBD bd) {
		this.bd = bd;
	}
	
	@Override
	@GetMapping("/employee/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/addEmployee";
	}

	@Override
	@GetMapping("/employee/delete/{businessentityid}")
	public String deleteEmployee(@PathVariable("businessentityid") Integer businessentityid, Model model) {
		bd.deleteEmployee(businessentityid);
		model.addAttribute("employees", bd.findAllEmployee());
		return "employee/index";
	}

	@Override
	@GetMapping("/employee/")
	public String indexEmployee(Model model) {
		model.addAttribute("employees", bd.findAllEmployee());
		return "employee/index";
	}

	@Override
	@PostMapping("/employee/addEmployee")
	public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult, Model model,
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
	@GetMapping("/employee/editEmployee/{businessentityid}")
	public String showUpdateForm(@PathVariable("businessentityid") Integer businessentityid, Model model) {
		Employee employee = bd.findEmployeeById(businessentityid);
		if (employee == null) 
			throw new IllegalArgumentException("Invalid employee Id: " + businessentityid);
		model.addAttribute("employee", employee);
		return "employee/editEmployee";
	}

	@Override
	@PostMapping("/employee/editEmployee/{businessentityid}")
	public String updateEmployee(@PathVariable("businessentityid") Integer businessentityid, @RequestParam(value = "action", required = true) String action, 
			@ModelAttribute Employee employee, BindingResult bindingResult, Model model) {
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
	
	@Override
	@GetMapping("/info/employee/{businessentityid}")
	public String showInfoForm(@PathVariable("businessentityid") Integer businessentityid, Model model) {
		Employee employee = bd.findEmployeeById(businessentityid);
		model.addAttribute("employee", employee);
		return "info/employee";
	}

}
