package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}
	@Transactional
	public List<Country> searchCountryLike(String name) {
		return countryRepository.findByNameContainingIgnoreCase(name);
	}
	
	@Transactional
	public List<Country> searchCountryLikeAscOrder(String name) {
		return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
	}
	
	@Transactional
	public List<Country> searchCountryfirstLetter(String letter) {
		return countryRepository.findByNameStartingWith(letter);
	}
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country Not Found");
		}
		return result.get();
	}

	@Transactional

	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void updateCountry(String code, String name) {
		Optional<Country> result = countryRepository.findById(code);
		Country country = result.get();
		country.setName(name);
		countryRepository.save(country);
	}

	@Transactional
	public void deleteCountry(String code) {

		countryRepository.deleteById(code);
	}

}
