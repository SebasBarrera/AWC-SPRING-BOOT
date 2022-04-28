package com.sebas.taller.controller.person;

import java.util.Optional;

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

import com.sebas.taller.model.person.Address;
import com.sebas.taller.service.person.AddressService;
import com.sebas.taller.service.person.StateprovinceService;

@Controller
public class AddressControllerImp implements AddressController {
	
	AddressService as;
	StateprovinceService ss; 
	
	@Autowired
	public AddressControllerImp(AddressService as, StateprovinceService ss) {
		this.as = as;
		this.ss = ss;
	}

	@Override
	@GetMapping("/address/addAddress")
	public String addAddress(Model model) {
		model.addAttribute("address", new Address());
		
		model.addAttribute("stateprovinces", ss.findAll());
		return "address/addAddress";
	}

	@Override
	@GetMapping("/address/delete/{addressid}")
	public String deleteAddress(@PathVariable("addressid") Integer addressid, Model model) {
		Address address = as.findById(addressid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid address Id:" + addressid));
		as.delete(address);
		model.addAttribute("addresss", as.findAll());
		return "address/index";
	}

	@Override
	@GetMapping("/address/")
	public String indexAddress(Model model) {
		/*
		as.save(new Address());
		if (as.findAll().iterator().hasNext() == false ) {
			model.addAttribute("addresss", null);
		} else {
			model.addAttribute("addresss", as.findAll());
		}
		*/ 
		model.addAttribute("addresss", as.findAll());
		return "address/index";
	}

	@Override
	@PostMapping("/address/addAddress")
	public String saveAddress(@Validated @ModelAttribute Address address, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("address", address);
				model.addAttribute("stateprovinces", ss.findAll());
				return "address/addAddress";
			}
			as.save(address);
		}
		return "redirect:/address/";
	}

	@Override
	@GetMapping("/address/editAddress/{addressid}")
	public String showUpdateForm(@PathVariable("addressid") Integer addressid, Model model) {
		Optional<Address> address = as.findById(addressid);
		if(address == null)
			throw new IllegalArgumentException("Invalid user Id: " + addressid);
		model.addAttribute("address", address.get());


		model.addAttribute("stateprovinces", ss.findAll());
		return "address/editAddress";
	}

	@Override
	@PostMapping("/address/editAddress/{addressid}")
	public String updateAddress(@PathVariable("addressid") Integer addressid, @RequestParam(value = "action", required = true) String action, 
			@Validated @ModelAttribute Address address, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("address", address);
				model.addAttribute("stateprovinces", ss.findAll());
				return "address/editAddress";
			}
			as.save(address);
			model.addAttribute("addresss", as.findAll());
		}
		return "redirect:/address/";
	}

	

}
