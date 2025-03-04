package com.dpbm.rss.controllers;

import com.dpbm.rss.exceptions.UserNotFound;
import com.dpbm.rss.model.User;
import com.dpbm.rss.service.ReturnMessage;
import com.dpbm.rss.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) throws UserNotFound {
        User foundUser = userService.getUser(id);
        return new ResponseEntity<User>(foundUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReturnMessage> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        ReturnMessage message = new ReturnMessage("Delete User");
        return new ResponseEntity<ReturnMessage>(message, HttpStatus.OK);
    }
}
