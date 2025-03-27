package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.*;
import com.dpbm.rss.model.Post;
import com.dpbm.rss.model.Publisher;
import com.dpbm.rss.model.Rss;

import java.util.List;


public interface PostService {

        Post addPost(Post post)  throws InsertWithId,InvalidRss;
        Post getPost(String id) throws PostNotFound;
        List<Post> getPosts();
        void deletePost(String id);
        Post updatePost(Post post)  throws UpdateWithoutId;
}
