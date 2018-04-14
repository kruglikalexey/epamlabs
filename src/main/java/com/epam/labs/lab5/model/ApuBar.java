package com.epam.labs.lab5.model;

import com.epam.labs.lab5.aop.Bye;
import com.epam.labs.lab5.aop.Hello;
import com.epam.labs.lab5.aop.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApuBar implements Bar {

    @Override
    @Autowired
    @Hello
    @Bye
    @Profile
    public Squishee sell(Customer customer) {
        if (!customer.isBroke()) {
            return new Squishee(String.format("Squishee for %s", customer.getName()));
        } else {
            throw new CustomerBrokenException();
        }
    }
}
