package com.epam.labs.lab3_4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;

    String name;

    String codeName;

    public Country(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }
}

