package com.example.intermove.Forum.Services;


import com.example.intermove.Entities.Forum.Post;
import com.example.intermove.Entities.Forum.Post;
import com.example.intermove.Forum.Controller.ResourceNotFoundException;
import com.example.intermove.Forum.Repositoryy.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "postID", postId));
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long postId, Post postDetails) {
        Post post = getPostById(postId);
        post.setTitle(postDetails.getTitle());
        post.setPostdescription(postDetails.getPostdescription());
        post.setPostimage(postDetails.getPostimage());
        post.setCreated_at(postDetails.getCreated_at());
        return postRepository.save(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}

