package com.sebas.taller.service.person;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.interfaces.CountryregionDao;
import com.sebas.taller.dao.interfaces.StateprovinceDao;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.person.StateprovinceAndAddresses;
import com.sebas.taller.repository.sales.SalesterritoryRepository;

@Service
@Transactional
public class StateprovinceServiceImp implements StateprovinceService {

	private StateprovinceDao stateprovinceDao;
	private CountryregionDao countryregionDao;
	private SalesterritoryRepository tr;

	@Autowired
	public StateprovinceServiceImp(StateprovinceDao sr, CountryregionDao cr, SalesterritoryRepository tr) {
		this.stateprovinceDao = sr;
		this.countryregionDao = cr;
		this.tr = tr;
	}

	@Override
	@Transactional
	public Stateprovince save(Stateprovince s) {
		if (s != null) {

			if (s.getCountryregion() == null || s.getTerritoryid() == null) {
				throw new NullPointerException();

			} else if (!countryregionDao.existsById(s.getCountryregion().getCountryregionid()) || !tr.existsById(s.getTerritoryid())) {
				throw new NullPointerException();
			}

			if (
					s.getStateprovincecode().length() == 5 && 
					s.getName().length() >= 5 &&
					(s.getIsonlystateprovinceflag().equals("Y") || s.getIsonlystateprovinceflag().equals("N")) &&
					s.getStateprovincecode().chars().allMatch(Character::isDigit)) {

				s.setCountryregion(countryregionDao.findById(s.getCountryregion().getCountryregionid()));
				s.setTerritoryid(tr.findById(s.getTerritoryid()).get().getTerritoryid());

				stateprovinceDao.save(s);


			} else {
				throw new IllegalArgumentException();
			}

		} else {
			throw new NullPointerException();
		}
		return stateprovinceDao.findById(s.getStateprovinceid());
	}

	@Override
	@Transactional
	public Stateprovince update(Stateprovince s) {
		Stateprovince real = null;
		if (s != null) {

			if (s.getCountryregion() == null || s.getTerritoryid() == null) {
				throw new NullPointerException();

			} else if (!countryregionDao.existsById(s.getCountryregion().getCountryregionid()) || !tr.existsById(s.getTerritoryid())) {
				throw new NullPointerException();
			}

			real = search(s);
			if (s.getStateprovincecode().length() == 5 && s.getName().length() >= 5 &&
					(s.getIsonlystateprovinceflag().equals("Y") || s.getIsonlystateprovinceflag().equals("N"))
					&& s.getStateprovincecode().chars().allMatch(Character::isDigit)) {

				stateprovinceDao.update(s);

			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
		return real;
	}

	@Override
	public Stateprovince search(Stateprovince s) {
		Stateprovince searched = null;
		if (stateprovinceDao.existsById(s.getStateprovinceid())) {

			searched = stateprovinceDao.findById(s.getStateprovinceid());

		} else {

			throw new NullPointerException();
		}
		return searched;
	}

	@Override
	public Stateprovince findById(Integer id) {
		return stateprovinceDao.findById(id);
	}

	@Override
	public Iterable<Stateprovince> findAll() {
		return stateprovinceDao.findAll();
	}

	@Override
	public void delete(Stateprovince s) {
		stateprovinceDao.delete(s);
	}

	@Override
	public Iterable<StateprovinceAndAddresses> specialFind(Integer id) {
		List<Object[]> rawResult = stateprovinceDao.findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(id);
		List<StateprovinceAndAddresses> entityList = new ArrayList<>();
		for (Object[] objectArray : rawResult) {
			Stateprovince sp = (Stateprovince) objectArray[0];
			long numAddresses = (long) objectArray[1];
			StateprovinceAndAddresses spa = new StateprovinceAndAddresses();
			spa.setSp(sp);
			spa.setAddresses(numAddresses);
			entityList.add(spa);
		}
		return entityList;
	}

	@Override
	public Iterable<Integer> specialFindAmount(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
