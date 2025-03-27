package com.dpbm.rss.service;

import com.dpbm.rss.exceptions.*;
import com.dpbm.rss.model.Post;
import com.dpbm.rss.model.Rss;
import com.dpbm.rss.model.User;
import com.dpbm.rss.repository.PostRepository;
import com.dpbm.rss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;


    @Override
    public Post addPost(Post post)  throws InsertWithId,InvalidRss{
        if(post.getId() != null){
            throw new InsertWithId();
        }

        if(post.getRss() == null){
            throw new InvalidRss();
        }

        return postRepository.save(post);
    }

    @Override
    public Post getPost(String id) throws PostNotFound{
        Optional<Post> post = postRepository.findById(id);

        if(post.isEmpty()){
            throw new PostNotFound();
        }

        return post.get();
    }

    @Override
    public List<Post> getPosts(){
        Iterable<Post> postsIter = postRepository.findAll();
        List<Post> posts = StreamSupport.stream(postsIter.spliterator(), false).toList();
        return posts;
    }

    @Override
    public void deletePost(String id){
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Post post) throws UpdateWithoutId{
        if(post.getId() == null || post.getId().isEmpty()){
            throw new UpdateWithoutId();
        }
        return postRepository.save(post);
    }


}
