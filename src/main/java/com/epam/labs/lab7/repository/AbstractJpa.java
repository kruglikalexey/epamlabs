package com.epam.labs.lab7.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class AbstractJpa {

    protected EntityManagerFactory emf;

    public AbstractJpa() {
        super();
    }

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

}