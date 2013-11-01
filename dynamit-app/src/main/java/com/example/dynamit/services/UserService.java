package com.example.dynamit.services;

import java.util.List;

/**
 * @author Ivan Khalopik
 */
public interface UserService {

    User get(int id);

    void save(User user);

    List<User> all();
}
