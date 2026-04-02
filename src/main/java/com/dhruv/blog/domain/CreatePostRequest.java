package com.dhruv.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePostRequest {
    private String title;

    private String content;

    private Long categoryId;

    private PostStatus status;

    @Builder.Default
    private Set<Long> tagIds = new HashSet<>();
}
