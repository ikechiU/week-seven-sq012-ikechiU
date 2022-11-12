package com.example.weeksevensq012ikechiu.service.impl.shared;

import com.example.weeksevensq012ikechiu.io.entity.CommentEntity;
import com.example.weeksevensq012ikechiu.io.repository.CommentRepository;
import com.example.weeksevensq012ikechiu.model.response.CommentRest;
import com.example.weeksevensq012ikechiu.shared.dto.CommentDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Type;
import java.util.List;

public class CommentShare {
    public static List<CommentDto> getCommentDto(int cPage, int cLimit, Long postId, ModelMapper modelMapper, CommentRepository commentRepository) {
        if (cPage > 0) cPage = cPage - 1;
        PageRequest cPageable = PageRequest.of(cPage, cLimit, Sort.by("id").descending());
        Page<CommentEntity> commentEntities = commentRepository.findAllByPostId(postId, cPageable);

        Type cDtoType = new TypeToken<List<CommentDto>>() {}.getType();
        return modelMapper.map(commentEntities.getContent(), cDtoType);
    }

    public static List<CommentRest> getCommentRests(int cPage, int cLimit, Long postId, ModelMapper modelMapper, CommentRepository commentRepository) {
        if (cPage > 0) cPage = cPage - 1;
        PageRequest cPageable = PageRequest.of(cPage, cLimit, Sort.by("id").descending());
        Page<CommentEntity> commentEntities = commentRepository.findAllByPostId(postId, cPageable);

        Type cRestType = new TypeToken<List<CommentRest>>() {}.getType();
        return modelMapper.map(commentEntities.getContent(), cRestType);
    }
}
