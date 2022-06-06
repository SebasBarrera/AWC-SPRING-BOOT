package com.sebas.taller.controller.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sebas.taller.bussinessDelegate.interfaces.SpecialqueriesBD;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.person.StateprovinceAndAddresses;

@Controller
public class SpecialqueriesControllerImp implements SpecialqueriesController {

	SpecialqueriesBD bd;
	
	@Autowired
	public SpecialqueriesControllerImp(SpecialqueriesBD bd) {
		this.bd = bd;
	}
	
	@Override
	@GetMapping("/specialqueries/address/1")
	public String indexQueries1(Model model) {
		List<StateprovinceAndAddresses> specialQueryResult = bd.findSpecialStateprovinces1();
		List<Stateprovince> stateprovincesFromQuery = new ArrayList<>();
		List<Long> amountOfAddressesFromQuery = new ArrayList<>();
		for (StateprovinceAndAddresses spa : specialQueryResult) {
			stateprovincesFromQuery.add(spa.getSp());
			amountOfAddressesFromQuery.add(spa.getAddresses());
		}

		model.addAttribute("stateprovinces", specialQueryResult);
		model.addAttribute("addresses", bd.findSpecialAddresses());
		return "specialqueries/index";
	}
	
	@Override
	@GetMapping("/specialqueries/address/2")
	public String indexQueries2(Model model) {
		List<StateprovinceAndAddresses> specialQueryResult = bd.findSpecialStateprovinces2();
		List<Stateprovince> stateprovincesFromQuery = new ArrayList<>();
		List<Long> amountOfAddressesFromQuery = new ArrayList<>();
		for (StateprovinceAndAddresses spa : specialQueryResult) {
			stateprovincesFromQuery.add(spa.getSp());
			amountOfAddressesFromQuery.add(spa.getAddresses());
		}

		model.addAttribute("stateprovinces", specialQueryResult);
		model.addAttribute("addresses", bd.findSpecialAddresses());
		return "specialqueries/index";
	}
	@Override
	@GetMapping("/specialqueries/address/3")
	public String indexQueries3(Model model) {
		List<StateprovinceAndAddresses> specialQueryResult = bd.findSpecialStateprovinces3();
		List<Stateprovince> stateprovincesFromQuery = new ArrayList<>();
		List<Long> amountOfAddressesFromQuery = new ArrayList<>();
		for (StateprovinceAndAddresses spa : specialQueryResult) {
			stateprovincesFromQuery.add(spa.getSp());
			amountOfAddressesFromQuery.add(spa.getAddresses());
		}

		model.addAttribute("stateprovinces", specialQueryResult);
		model.addAttribute("addresses", bd.findSpecialAddresses());
		return "specialqueries/index";
	}
	@Override
	@GetMapping("/specialqueries/address/4")
	public String indexQueries4(Model model) {
		List<StateprovinceAndAddresses> specialQueryResult = bd.findSpecialStateprovinces4();
		List<Stateprovince> stateprovincesFromQuery = new ArrayList<>();
		List<Long> amountOfAddressesFromQuery = new ArrayList<>();
		for (StateprovinceAndAddresses spa : specialQueryResult) {
			stateprovincesFromQuery.add(spa.getSp());
			amountOfAddressesFromQuery.add(spa.getAddresses());
		}

		model.addAttribute("stateprovinces", specialQueryResult);
		model.addAttribute("addresses", bd.findSpecialAddresses());
		return "specialqueries/index";
	}
	@Override
	@GetMapping("/specialqueries/address/5")
	public String indexQueries5(Model model) {
		List<StateprovinceAndAddresses> specialQueryResult = bd.findSpecialStateprovinces5();
		List<Stateprovince> stateprovincesFromQuery = new ArrayList<>();
		List<Long> amountOfAddressesFromQuery = new ArrayList<>();
		for (StateprovinceAndAddresses spa : specialQueryResult) {
			stateprovincesFromQuery.add(spa.getSp());
			amountOfAddressesFromQuery.add(spa.getAddresses());
		}

		model.addAttribute("stateprovinces", specialQueryResult);
		model.addAttribute("addresses", bd.findSpecialAddresses());
		return "specialqueries/index";
	}

}
