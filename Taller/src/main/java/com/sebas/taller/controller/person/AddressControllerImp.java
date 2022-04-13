package com.sebas.taller.controller.person;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.service.person.AddressService;

@Controller
public class AddressControllerImp implements AddressController {
	
	AddressService as;
	
	@Autowired
	public AddressControllerImp(AddressService as) {
		this.as = as;
	}

	@Override
	@GetMapping("/address/add")
	public String addAddress(Model model, Address a) {
		// TODO ??
		return "address/addAddress";
	}

	@Override
	@GetMapping("/address/delete/{addressid}")
	public String deleteAddress(@PathVariable("addressid") Integer addressid, Model model) {
		Address a = as.findById(addressid).orElseThrow(() -> new IllegalArgumentException("Invalid address Id:" + addressid));
		as.delete(a);
		return "redirect:/address/";
	}

	@Override
	@GetMapping("/address/")
	public String indexAddress(Model model) {
		model.addAttribute("addresss", as.findAll());
		return "address/index";
	}

	@Override
	@PostMapping("/address/add")
	public String saveAddress(Address a, @RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel"))
			as.save(a);
		return "redirect:/address/";
	}

	@Override
	@GetMapping("/address/edit/{addressid}")
	public String showUpdateForm(@PathVariable("addressid") Integer addressid, Model model) {
		Optional<Address> a = as.findById(addressid);
		if(a == null)
			throw new IllegalArgumentException("Invalid user Id: " + addressid);
		model.addAttribute("address", a.get());
		//TODO?
		return "address/updateAddress";
	}

	@Override
	@PostMapping("/address/edit/{addressid}")
	public String updateAddress(@PathVariable("addressid") Integer addressid, @RequestParam(value = "action", required = true) String action, Address a, Model model) {
		if (action != null && !action.equals("Cancel")) 
			as.save(a);
		return "redirect:/address/";
	}

	@Override
	public String login(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
