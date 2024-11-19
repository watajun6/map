package com.example.ogumap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ogumap.entity.Post;
import com.example.ogumap.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getLatestPosts() {
        return postRepository.findTop10ByOrderByCreatedAtDesc();
    }
}