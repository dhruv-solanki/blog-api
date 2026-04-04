package com.dhruv.blog.service;

import com.dhruv.blog.domain.CreatePostRequest;
import com.dhruv.blog.domain.UpdatePostRequest;
import com.dhruv.blog.domain.entity.Post;
import com.dhruv.blog.domain.entity.User;

import java.util.List;

public interface PostService {
    Post getPost(Long id);

    List<Post> getAllPosts(Long categoryId, Long tagId);

    List<Post> getDraftPosts(User user);

    Post createPost(User user, CreatePostRequest createPostRequest);

    Post updatePost(Long id, UpdatePostRequest updatePostRequest);
}
