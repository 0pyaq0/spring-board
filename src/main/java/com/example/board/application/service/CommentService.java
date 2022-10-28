package com.example.board.application.service;

import com.example.board.application.dto.CommentDto;
import com.example.board.domain.Comment;
import com.example.board.domain.Posts;
import com.example.board.domain.User;
import com.example.board.infrastructure.persistence.CommentRepository;
import com.example.board.infrastructure.persistence.PostsRepository;
import com.example.board.infrastructure.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    /* CREATE */
    @Transactional
    public Long save(Long id, String nickname, CommentDto.Request dto) {
        User user = userRepository.findByNickname(nickname);
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다. " + id));

        dto.setUser(user);
        dto.setPosts(posts);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return comment.getId();
    }

    /* READ */
    @Transactional(readOnly = true)
    public List<CommentDto.Response> findAll(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id : " + id));

        List<Comment> comments = posts.getComments();
        return comments.stream().map(CommentDto.Response::new).collect(Collectors.toList());
    }

    /* UPDATE */
    @Transactional
    public void update(Long id, CommentDto.Request dto) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + id));

        comment.update(dto.getComment());
    }

    /* DELETE */
    @Transactional
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id = " + id));

        commentRepository.delete(comment);
    }
}
