package com.example.board.application.service;

import com.example.board.application.dto.PostsDto;
import com.example.board.domain.Posts;
import com.example.board.domain.Role;
import com.example.board.domain.User;
import com.example.board.infrastructure.persistence.PostsRepository;
import com.example.board.infrastructure.persistence.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class PostsServiceTest {
    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void clear() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_생성() {
        User user = User.builder().username("benny").nickname("benny").email("benny@benny.com").role(Role.USER).build();

        PostsDto.Request posts = PostsDto.Request.builder()
                .title("Test Title")
                .writer(user.getNickname())
                .content("Test Content")
                .view(0)
                .user(user)
                .build();

        postsService.save(posts, user.getNickname());

        log.info(String.valueOf(posts));
    }
}