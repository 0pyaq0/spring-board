package com.example.board.infrastructure.persistence;

import com.example.board.domain.Comment;
import com.example.board.domain.Posts;
import com.example.board.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @AfterEach
    public void clear() { commentRepository.deleteAll(); }

    @Test
    public void 게시글_댓글_생성_조회(){
        String content = "댓글";

        Posts posts = Posts.builder().id(1L).build();
        User user = User.builder().id(1L).build();

        commentRepository.save(Comment.builder()
                        .comment(content)
                        .user(user)
                        .posts(posts)
                .build());

        List<Comment> comments = commentRepository.getCommentByPostsOrderById(posts);
        Comment comment = comments.get(0);
        assertThat(comment.getComment()).isEqualTo(content);
    }

}