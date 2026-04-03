package com.dhruv.blog.service.impl;

import com.dhruv.blog.domain.CreatePostRequest;
import com.dhruv.blog.domain.PostStatus;
import com.dhruv.blog.domain.entity.Category;
import com.dhruv.blog.domain.entity.Post;
import com.dhruv.blog.domain.entity.Tag;
import com.dhruv.blog.domain.entity.User;
import com.dhruv.blog.repository.PostRepository;
import com.dhruv.blog.service.CategoryService;
import com.dhruv.blog.service.PostService;
import com.dhruv.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final TagService tagService;

    private static final int WORDS_PER_MINUTE = 200;

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAllPosts(Long categoryId, Long tagId) {
        if(categoryId != null && tagId != null) {
            Category category = categoryService.getCategoryById(categoryId);
            Tag tag = tagService.getTagById(tagId);

            return postRepository.findAllByStatusAndCategoryAndTagsContaining(
                    PostStatus.PUBLISHED,
                    category,
                    tag
            );
        }

        if(categoryId != null) {
            Category category = categoryService.getCategoryById(categoryId);
            return postRepository.findAllByStatusAndCategory(
                    PostStatus.PUBLISHED,
                    category
            );
        }

        if(tagId != null) {
            Tag tag = tagService.getTagById(tagId);
            return postRepository.findAllByStatusAndTagsContaining(
                    PostStatus.PUBLISHED,
                    tag
            );
        }

        return postRepository.findAllByStatus(PostStatus.PUBLISHED);
    }

    @Override
    public List<Post> getDraftPosts(User user) {
        return postRepository.findAllByStatusAndAuthor(PostStatus.DRAFT, user);
    }

    @Override
    public Post createPost(User user, CreatePostRequest request) {
        Category category = categoryService.getCategoryById(request.getCategoryId());
        List<Tag> tags = tagService.getTagByIds(request.getTagIds());

        Post newPost = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .status(request.getStatus())
                .author(user)
                .readingTime(calculateReadingTime(request.getContent()))
                .category(category)
                .tags(new HashSet<>(tags))
                .build();

        return postRepository.save(newPost);
    }

    private Integer calculateReadingTime(String content) {
        if(content == null || content.isEmpty()) {
            return 0;
        }

        int wordCount = content.trim().split("\\s+").length;
        return (int) Math.ceil((double) wordCount / WORDS_PER_MINUTE);
    }
}
