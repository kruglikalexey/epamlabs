package com.epam.labs.lab6.repository;

import com.epam.labs.lab6.model.Country;
import org.springframework.jdbc.core.RowMapper;

public class RepositoryConstants {
    static final String ID = "id";
    static final String NAME = "name";
    static final String CODE_NAME = "code_name";

    static final RowMapper<Country> ROW_CALLBACK_HANDLER = (resultSet, i) -> {
        Country country = new Country();
        country.setId(resultSet.getInt(ID));
        country.setCodeName(resultSet.getString(NAME));
        country.setName(resultSet.getString(CODE_NAME));
        return country;
    };

    static final String SELECT_FROM_COUNTRY = "select * from country";
    static final String UPDATE_COUNTRY_SET_NAME_WHERE_CODE_NAME = "update country SET name=? where CODE_NAME=?";
    static final String SELECT_FROM_COUNTRY_WHERE_CODE_NAME = "select * from country where CODE_NAME=?";
    static final String SELECT_FROM_COUNTRY_WHERE_NAME = "select * from country where NAME=?";
}
