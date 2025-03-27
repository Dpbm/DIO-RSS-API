package com.dpbm.rss.controllers;

import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.exceptions.RssNotFound;
import com.dpbm.rss.exceptions.UpdateWithoutId;
import com.dpbm.rss.exceptions.UserNotFound;
import com.dpbm.rss.model.User;
import com.dpbm.rss.service.ReturnMessage;
import com.dpbm.rss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) throws InsertWithId {
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) throws UserNotFound {
        User foundUser = userService.getUser(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReturnMessage> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        ReturnMessage message = new ReturnMessage("Deleted User");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) throws UpdateWithoutId {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<User> addRSS(@Param("userId") String userId, @Param("rssId") String rssId) throws RssNotFound,UserNotFound {
        User newUser = userService.addRss(userId, rssId);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
