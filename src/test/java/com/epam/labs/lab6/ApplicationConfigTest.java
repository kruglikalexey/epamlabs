package com.epam.labs.lab6;

import com.epam.labs.lab6.model.Country;
import com.epam.labs.lab6.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class ApplicationConfigTest {

    @Autowired
    private CountryRepository repository;

    @Test
    void test() {
        assertThat(repository.getCountries(), is(contains(new Country(2, "Russia", "RU"))));
    }
}