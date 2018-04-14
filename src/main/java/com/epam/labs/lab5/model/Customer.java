package com.epam.labs.lab5.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Component
public class Customer extends UsualPerson {
    private String name;
    private boolean isBroke;
}
