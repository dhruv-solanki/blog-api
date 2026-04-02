package com.dhruv.blog.service.impl;

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

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final TagService tagService;

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
}
