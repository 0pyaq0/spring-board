package com.example.board.infrastructure.persistance;

import com.example.board.domain.Posts;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void clear(){
        postsRepository.deleteAll();
    }

    @Test
    public void createPostsAndGetPosts(){
        Posts posts = Posts.builder()
                .title("제목")
                .content("내용")
                .writer("작성자")
                .build();
        postsRepository.save(posts);

        List<Posts> postsList = postsRepository.findAll();
        log.info(postsList.get(0));
    }
}