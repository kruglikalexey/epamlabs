package com.epam.labs.lab7.repository;

import com.epam.labs.lab7.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CountryJpaRepository extends AbstractJpa implements CountryRepository {

    @Override
    public void save(Country country) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        if (em != null) {
            em.close();
        }
    }

    @Override
    public List<Country> getAllCountries() {

        List<Country> countryList = null;
        EntityManager em = emf.createEntityManager();

        countryList = em.createQuery("from Country", Country.class)
                .getResultList();
        if (em != null) {
            em.close();
        }
        return countryList;
    }

    @Override
    public Country getCountryByName(String name) {

        EntityManager em = emf.createEntityManager();
        em.createQuery("from Country", Country.class).getResultList();

        Country country = em
                .createQuery("SELECT c FROM Country c WHERE c.name LIKE :name",
                        Country.class).setParameter("name", name)
                .getSingleResult();

        if (em != null) {
            em.close();
        }

        return country;
    }

}
