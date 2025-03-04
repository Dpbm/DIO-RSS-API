package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.UserNotFound;
import com.dpbm.rss.model.User;
import com.dpbm.rss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user){
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
}
