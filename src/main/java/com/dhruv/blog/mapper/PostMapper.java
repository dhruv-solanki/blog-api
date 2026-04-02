package com.dhruv.blog.mapper;

import com.dhruv.blog.domain.CreatePostRequest;
import com.dhruv.blog.domain.dto.CreatePostRequestDto;
import com.dhruv.blog.domain.dto.PostDto;
import com.dhruv.blog.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);
}
