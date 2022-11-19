package com.example.weeksevensq012ikechiu.service.impl;

import com.example.weeksevensq012ikechiu.exception.ErrorMessages;
import com.example.weeksevensq012ikechiu.io.entity.PostEntity;
import com.example.weeksevensq012ikechiu.io.entity.PostLikeEntity;
import com.example.weeksevensq012ikechiu.io.entity.UserEntity;
import com.example.weeksevensq012ikechiu.io.repository.PostLikeRepository;
import com.example.weeksevensq012ikechiu.io.repository.PostRepository;
import com.example.weeksevensq012ikechiu.io.repository.UserRepository;
import com.example.weeksevensq012ikechiu.model.response.*;
import com.example.weeksevensq012ikechiu.service.PostLikeService;
import com.example.weeksevensq012ikechiu.shared.dto.PostLikeDto;
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
public class PostLikeServiceImpl implements PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ResponseManager<PostLikeRest> responseManager;
    private final ModelMapper modelMapper;


    @Override
    public ApiResponse<PostLikeRest> updatePostLike(Long postId, String userId) {

        UserEntity userEntity = userRepository.findByUserId(userId).orElse(null);
        if (userEntity == null)
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        PostEntity postEntity = postRepository.findById(postId).orElse(null);
        if(postEntity == null)
            return responseManager.error(HttpStatus.BAD_REQUEST, ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        PostLikeEntity postLikeEntity = postLikeRepository.findAllByPostIdAndUserId(postId, userId);
        PostLikeEntity postLike = new PostLikeEntity();
        postLike.setLiked(true);
        if (postLikeEntity != null) {
            var like = postLikeEntity.isLiked();
            postLike.setLiked(!like);
            postLike.setId(postLikeEntity.getId());
        }

        postLike.setPostId(postId);
        postLike.setUserId(userId);
        postLike.setPosts(postEntity);

        PostLikeEntity updatedPostLike = postLikeRepository.save(postLike);
        PostLikeDto postLikeDto = modelMapper.map(updatedPostLike, PostLikeDto.class);
        PostLikeRest postLikeRest = modelMapper.map(postLikeDto, PostLikeRest.class);

        return responseManager.success(HttpStatus.CREATED, postLikeRest);
    }

}
