package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.exceptions.RssNotFound;
import com.dpbm.rss.exceptions.UpdateWithoutId;
import com.dpbm.rss.exceptions.UserNotFound;
import com.dpbm.rss.model.User;

public interface UserService {
    User saveUser(User user)  throws InsertWithId;
    User getUser(String id) throws UserNotFound;
    void deleteUser(String id);
    User updateUser(User user)  throws UpdateWithoutId;
    User addRss(String userId, String rssId) throws RssNotFound,UserNotFound;
}
