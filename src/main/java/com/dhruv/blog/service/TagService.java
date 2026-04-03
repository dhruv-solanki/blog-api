package com.dhruv.blog.service;

import com.dhruv.blog.domain.entity.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<Tag> getTags();

    List<Tag> createTags(Set<String> tagNames);

    void deleteTag(Long id);

    Tag getTagById(Long id);

    List<Tag> getTagByIds(Set<Long> ids);
}
