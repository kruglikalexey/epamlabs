package com.epam.labs.lab7.repository;

import com.epam.labs.lab7.model.Country;

import java.util.List;

public interface CountryRepository {

    void save(Country country);

    List<Country> getAllCountries();

    Country getCountryByName(String name);

}