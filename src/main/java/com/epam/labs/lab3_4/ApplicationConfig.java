package com.epam.labs.lab3_4;

import com.epam.labs.lab3_4.model.Country;
import com.epam.labs.lab3_4.model.Person;
import com.epam.labs.lab3_4.model.UsualPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class ApplicationConfig {

    @Bean
    @Autowired
    Person person(Country country) {
        return UsualPerson
                .builder()
                .age(35)
                .name("John")
                .country(country)
                .build();
    }

    @Bean
    Country country() {
        return new Country("Russia", "RU");
    }

}
