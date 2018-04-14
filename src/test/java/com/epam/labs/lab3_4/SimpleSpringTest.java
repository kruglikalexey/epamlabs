package com.epam.labs.lab3_4;

import com.epam.labs.lab3_4.model.Country;
import com.epam.labs.lab3_4.model.Person;
import com.epam.labs.lab3_4.model.UsualPerson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class SimpleSpringTest {
    @Autowired
    Person person;

    @Autowired
    Country country;

    private static UsualPerson expectedPerson;

    @BeforeAll
    static void setUp() throws Exception {
        expectedPerson = getExpectedPerson();
    }


    static private UsualPerson getExpectedPerson() {
        UsualPerson person = new UsualPerson();
        person.setAge(35);
        person.setName("John");

        Country country = new Country();
        country.setName("Russia");
        country.setCodeName("RU");

        person.setCountry(country);

        return person;
    }


    @Test
    void test() {
        UsualPerson usualPerson = (UsualPerson) person;
        assertThat(usualPerson.getName(), is(expectedPerson.getName()));
        assertThat(usualPerson.getAge(), is(expectedPerson.getAge()));
        assertThat(usualPerson.getCountry(), is(expectedPerson.getCountry()));
    }
}
