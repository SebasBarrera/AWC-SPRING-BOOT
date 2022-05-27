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

import com.sebas.taller.bussinessDelegate.interfaces.AddressBD;
import com.sebas.taller.bussinessDelegate.interfaces.StateprovinceBD;
import com.sebas.taller.model.person.Address;

@Controller
public class AddressControllerImp implements AddressController {
	
	AddressBD bd;
	StateprovinceBD sbd;
	
	@Autowired
	public AddressControllerImp(AddressBD bd, StateprovinceBD sbd) {
		this.sbd = sbd;
		this.bd = bd;
	}

	@Override
	@GetMapping("/address/addAddress")
	public String addAddress(Model model) {
		model.addAttribute("address", new Address());
		
		model.addAttribute("stateprovinces", sbd.findAllStateprovince());
		return "address/addAddress";
	}

	@Override
	@GetMapping("/address/delete/{addressid}")
	public String deleteAddress(@PathVariable("addressid") Integer addressid, Model model) {
//		Address address = as.findById(addressid);
				
		bd.deleteAddress(addressid);
		model.addAttribute("addresss", bd.findAllAddress());
		return "address/index";
	}

	@Override
	@GetMapping("/address/")
	public String indexAddress(Model model) {
		/*
		as.save(new Address());
		if (bd.findAllAddress().iterator().hasNext() == false ) {
			model.addAttribute("addresss", null);
		} else {
			model.addAttribute("addresss", bd.findAllAddress());
		}
		*/ 
		model.addAttribute("addresss", bd.findAllAddress());
		return "address/index";
	}

	@Override
	@PostMapping("/address/addAddress")
	public String saveAddress(@Validated(Address.Validation.class) @ModelAttribute Address address, BindingResult bindingResult, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("address", address);
				model.addAttribute("stateprovinces", sbd.findAllStateprovince());
				return "address/addAddress";
			}
			bd.addAddress(address);
		}
		return "redirect:/address/";
	}

	@Override
	@GetMapping("/address/editAddress/{addressid}")
	public String showUpdateForm(@PathVariable("addressid") Integer addressid, Model model) {
		Address address = bd.findAddressById(addressid);
		if(address == null)
			throw new IllegalArgumentException("Invalid address Id: " + addressid);
		model.addAttribute("address", address);


		model.addAttribute("stateprovinces", sbd.findAllStateprovince());
		return "address/editAddress";
	}

	@Override
	@PostMapping("/address/editAddress/{addressid}")
	public String updateAddress(@PathVariable("addressid") Integer addressid, @RequestParam(value = "action", required = true) String action, 
			@Validated(Address.Validation.class) @ModelAttribute Address address, BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("address", address);
				model.addAttribute("stateprovinces", sbd.findAllStateprovince());
				return "address/editAddress";
			}
			bd.updateAddress(address);
			model.addAttribute("addresss", bd.findAllAddress());
		}
		return "redirect:/address/";
	}

	

}
