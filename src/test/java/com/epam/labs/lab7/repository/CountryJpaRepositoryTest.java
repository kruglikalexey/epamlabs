package com.epam.labs.lab7.repository;

import com.epam.labs.lab7.ApplicationConfig;
import com.epam.labs.lab7.model.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class CountryJpaRepositoryTest {

    private Country exampleCountry = new Country(2, "Russia", "RU");

    @Autowired
    private CountryRepository countryDao;

    @Test
    public void testSaveCountry() {

        countryDao.save(exampleCountry);

        List<Country> countryList = countryDao.getAllCountries();
        assertEquals(1, countryList.size());
        assertEquals(exampleCountry, countryList.get(0));
    }

    @Test
    public void testGtAllCountries() {

        countryDao.save(new Country("Canada", "CA"));

        List<Country> countryList = countryDao.getAllCountries();
        assertEquals(2, countryList.size());
    }

    @Test
    public void testGetCountryByName() {

        Country country = countryDao.getCountryByName("Russia");
        assertEquals(exampleCountry, country);
    }

}