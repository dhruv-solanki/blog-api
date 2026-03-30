package com.dhruv.blog.service.impl;

import com.dhruv.blog.domain.entity.Tag;
import com.dhruv.blog.repository.TagRepository;
import com.dhruv.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }
}
