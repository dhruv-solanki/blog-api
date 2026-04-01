package com.dhruv.blog.service;

import com.dhruv.blog.domain.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts(Long categoryId, Long tagId);
}
