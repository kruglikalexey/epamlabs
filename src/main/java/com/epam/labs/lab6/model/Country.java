package com.epam.labs.lab6.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Country implements Serializable {

    static final long serialVersionUID = 1L;

    int id;

    String name;

    String codeName;

    public Country(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }
}

