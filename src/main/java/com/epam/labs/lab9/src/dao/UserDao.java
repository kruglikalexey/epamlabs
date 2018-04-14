package com.epam.labs.lab9.src.dao;


import com.epam.labs.lab9.src.domain.User;

import java.util.List;

public interface UserDao {
    public void insert(User user);
    public User select(int id);
    public List<User> selectAll();
}