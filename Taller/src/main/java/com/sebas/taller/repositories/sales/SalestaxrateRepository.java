package com.sebas.taller.repositories.sales;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sebas.taller.model.sales.Salestaxrate;

@Repository
public interface SalestaxrateRepository extends CrudRepository<Salestaxrate, Integer>{

}
