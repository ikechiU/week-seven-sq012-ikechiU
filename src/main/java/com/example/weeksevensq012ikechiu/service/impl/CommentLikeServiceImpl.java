package com.example.weeksevensq012ikechiu.service.impl;

import com.example.weeksevensq012ikechiu.exception.ErrorMessages;
import com.example.weeksevensq012ikechiu.io.entity.CommentLikeEntity;
import com.example.weeksevensq012ikechiu.io.entity.PostEntity;
import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import com.example.weeksevensq012ikechiu.io.repository.CommentLikeRepository;
import com.example.weeksevensq012ikechiu.io.repository.CommentRepository;
import com.example.weeksevensq012ikechiu.io.repository.PostRepository;
import com.example.weeksevensq012ikechiu.io.repository.UserRepository;
import com.example.weeksevensq012ikechiu.model.response.*;
import com.example.weeksevensq012ikechiu.service.CommentLikeService;
import com.example.weeksevensq012ikechiu.shared.dto.CommentDto;
import com.example.weeksevensq012ikechiu.shared.dto.CommentLikeDto;
import com.example.weeksevensq012ikechiu.shared.dto.UserDto;
import com.example.weeksevensq012ikechiu.shared.utils.Utils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentLikeServiceImpl implements CommentLikeService {

    private final CommentLikeRepository commentLikeRepository;
    private final CommentRepository commentRepository;
    private final ResponseManager<CommentLikeRest> responseManager;

    private final UserRepository userRepository;

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse<CommentLikeRest> updateCommentLike(Long commentId, Long postId, String userId) {

        if (userRepository.findUserEntitiesByUserId(userId).orElse(null) == null)
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        if (postRepository.findById(postId).orElse(null) == null)
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        var comment = commentRepository.findById(commentId).orElse(null);
        if (comment == null)
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        CommentLikeEntity commentLikeEntity = commentLikeRepository
                .findCommentLikeEntitiesByCommentIdAndPostIdAndUserId(commentId, postId, userId);
        CommentLikeEntity comLike = new CommentLikeEntity();
        comLike.setLiked(true);

        if (commentLikeEntity != null) {
            var like = commentLikeEntity.isLiked();
            comLike.setLiked(!like);
            comLike.setId(commentLikeEntity.getId());
        }

        comLike.setUserId(userId);
        comLike.setPostId(postId);
        comLike.setCommentId(commentId);
        comLike.setComments(comment);

        var createdCommLike = commentLikeRepository.save(comLike);
        CommentLikeDto commentLikeDto = modelMapper.map(createdCommLike, CommentLikeDto.class);
        CommentLikeRest commentLikeRest = modelMapper.map(commentLikeDto, CommentLikeRest.class);

        return responseManager.success(HttpStatus.OK, commentLikeRest);
    }


}
