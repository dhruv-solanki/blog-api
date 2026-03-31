package com.dhruv.blog.service;

import com.dhruv.blog.domain.entity.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<Tag> getTags();

    List<Tag> createTags(Set<String> tagNames);
}
