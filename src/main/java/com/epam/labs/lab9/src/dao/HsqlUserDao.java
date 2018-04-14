package com.epam.labs.lab9.src.dao;

import com.epam.labs.lab9.src.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HsqlUserDao extends JdbcDaoSupport implements UserDao {

    @Override
    public void insert(User user) {

        if (user != null) {
            this.getJdbcTemplate().update(
                    "insert into user (firstname, lastname) values (?, ?)",
                    user.getFirstName(), user.getLastName());

        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public User select(int id) {

        User user = null;

        if (id > 0) {
            user = this.getJdbcTemplate().queryForObject(
                    "select id, firstname, lastname from user where id = ?",
                    new Object[] { id }, new UserMapper());
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        return this.getJdbcTemplate().query(
                "select id, firstname, lastname from user"
                , new UserMapper());
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            return user;
        }
    }
}