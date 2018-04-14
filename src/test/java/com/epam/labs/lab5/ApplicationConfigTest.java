package com.epam.labs.lab5;

import com.epam.labs.lab5.model.ApuBar;
import com.epam.labs.lab5.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class ApplicationConfigTest {
    @Autowired
    Customer customer;
    @Autowired
    ApuBar apuBar;

    @Test
    void test() {
        apuBar.sell(customer);
    }
}