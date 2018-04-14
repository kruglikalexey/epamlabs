package com.epam.labs.lab5;

import com.epam.labs.lab5.model.Customer;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.epam.labs.lab5")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationConfig {

    @Bean
    @Primary
    Customer customer() {
        Customer customer = new Customer();
        customer.setName("Alex");
        customer.setBroke(false);
        return customer;
    }

}
