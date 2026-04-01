package com.dhruv.blog.controller;

import com.dhruv.blog.domain.dto.PostDto;
import com.dhruv.blog.domain.entity.Post;
import com.dhruv.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long tagId
    ) {
        List<Post> posts = postService.getAllPosts(categoryId, tagId);
    }
}
