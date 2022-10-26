package com.example.board.presentation;

import com.example.board.application.service.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 화면 연결 Controller
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class PostsIndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/write")
    public String register() {
        return "posts-write";
    }
}
