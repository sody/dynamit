package com.example.dynamit.internal;

import com.example.dynamit.services.User;
import com.example.dynamit.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ivan Khalopik
 */
public class UserServiceImpl implements UserService {
    private final Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public UserServiceImpl() {
        save(new User("Admin"));
        save(new User("User"));
        save(new User("Anonymous"));
    }

    @Override
    public User get(final int id) {
        return new User(users.get(id));
    }

    @Override
    public void save(final User user) {
        if (user.getId() == null) {
            user.setId(idGenerator.getAndIncrement());
        }
        users.put(user.getId(), user);
    }

    @Override
    public List<User> all() {
        final ArrayList<User> copy = new ArrayList<User>(users.size());
        for (User user : users.values()) {
            copy.add(new User(user));
        }
        return copy;
    }
}
