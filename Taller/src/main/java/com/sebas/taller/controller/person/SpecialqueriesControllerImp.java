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
	@GetMapping("/specialqueries/address")
	public String indexQueries(Model model) {
		List<StateprovinceAndAddresses> specialQueryResult = bd.findSpecialStateprovinces();
		List<Stateprovince> stateprovincesFromQuery = new ArrayList<>();
		List<Long> amountOfAddressesFromQuery = new ArrayList<>();
		for (StateprovinceAndAddresses spa : specialQueryResult) {
			stateprovincesFromQuery.add(spa.getSp());
			amountOfAddressesFromQuery.add(spa.getAddresses());
		}
////		System.out.println(bd.findSpecialStateprovinces().size());
//		List<Stateprovince> spList = new ArrayList<Stateprovince>();
//		for (Object[] objects : specialQueryResult) {
//			spList.add((Stateprovince) objects[0]);
//		}
//		System.out.println(spList.size());
//		model.addAttribute("stateprovinces", stateprovincesFromQuery);
		model.addAttribute("stateprovinces", specialQueryResult);
//		model.addAttribute("amount", amountOfAddressesFromQuery);
//		model.addAttribute("amount", bd.findspecialAmountAddressInStateprovince());
//		model.addAttribute("stateprovinces", spList);
		model.addAttribute("addresses", bd.findSpecialAddresses());
		return "specialqueries/index";
	}

}
