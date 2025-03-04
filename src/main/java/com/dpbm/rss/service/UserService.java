package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.UserNotFound;
import com.dpbm.rss.model.User;

public interface UserService {
    User saveUser(User user);
    User getUser(String id) throws UserNotFound;
    void deleteUser(String id);
}
