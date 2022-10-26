package com.example.board.application.service;

import com.example.board.application.dto.PostsDto;
import com.example.board.domain.Posts;
import com.example.board.domain.User;
import com.example.board.infrastructure.persistence.PostsRepository;
import com.example.board.infrastructure.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    /* CREATE */
    @Transactional
    public Long save(PostsDto.Request dto, String nickname) {
        /* User 정보를 가져와 dto에 담아준다. */
        User user = userRepository.findByNickname(nickname);
        dto.setUser(user);
        log.info("PostsService save() 실행");
        Posts posts = dto.toEntity();
        postsRepository.save(posts);

        return posts.getId();
    }

}
