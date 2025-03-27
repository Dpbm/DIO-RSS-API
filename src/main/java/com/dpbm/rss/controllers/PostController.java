package com.dpbm.rss.controllers;

import com.dpbm.rss.exceptions.*;
import com.dpbm.rss.model.Post;
import com.dpbm.rss.model.User;
import com.dpbm.rss.service.PostService;
import com.dpbm.rss.service.ReturnMessage;
import com.dpbm.rss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) throws InsertWithId,InvalidRss {
        Post newPost = postService.addPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") String id) throws PostNotFound {
        Post foundPost = postService.getPost(id);
        return new ResponseEntity<>(foundPost, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getPosts(){
        List<Post> posts = postService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReturnMessage> deletePost(@PathVariable("id") String id) {
        postService.deletePost(id);
        ReturnMessage message = new ReturnMessage("Deleted Post");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post) throws UpdateWithoutId {
        Post updatedPost = postService.updatePost(post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

}
