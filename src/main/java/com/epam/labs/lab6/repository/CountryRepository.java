package com.epam.labs.lab6.repository;

import com.epam.labs.lab6.model.Country;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

import static com.epam.labs.lab6.repository.RepositoryConstants.*;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryRepository extends JdbcDaoSupport {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Country> getCountries() {
        return getJdbcTemplate().query(SELECT_FROM_COUNTRY, ROW_CALLBACK_HANDLER);
    }

    public void updateCountryName(String codeName, String newCountryName) {
        getJdbcTemplate().update(UPDATE_COUNTRY_SET_NAME_WHERE_CODE_NAME, newCountryName, codeName);
    }

    public Country getCountryByCodeName(String codeName) {
        return getJdbcTemplate().query(SELECT_FROM_COUNTRY_WHERE_CODE_NAME, ROW_CALLBACK_HANDLER).get(0);
    }

    public Country getCountryByName(String codeName) {
        return getJdbcTemplate().query(SELECT_FROM_COUNTRY_WHERE_NAME, ROW_CALLBACK_HANDLER).get(0);
    }
}
