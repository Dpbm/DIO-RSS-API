package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.exceptions.RssNotFound;
import com.dpbm.rss.exceptions.UpdateWithoutId;
import com.dpbm.rss.exceptions.UserNotFound;
import com.dpbm.rss.model.Rss;
import com.dpbm.rss.model.User;
import com.dpbm.rss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PublisherService publisherService;

    @Override
    public User saveUser(User user) throws  InsertWithId{
        if(user.getId() != null){
            throw new InsertWithId();
        }

        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) throws UserNotFound{
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFound();
        }

        return user.get();
    }

    @Override
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) throws UpdateWithoutId{
        if(user.getId() == null || user.getId().isEmpty()){
            throw new UpdateWithoutId();
        }
        return userRepository.save(user);
    }

    @Override
    public User addRss(String userId, String rssId) throws RssNotFound,UserNotFound{
        Rss rss = publisherService.getRss(rssId);
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()){
            throw new UserNotFound();
        }

        User userData = user.get();
        Set<Rss> rsss = userData.getRsss();
        rsss.add(rss);
        return userRepository.save(userData);
    }
}
