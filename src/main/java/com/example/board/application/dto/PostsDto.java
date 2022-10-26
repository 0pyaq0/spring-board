package com.example.board.application.dto;

import com.example.board.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdDate, modifiedDate;

    public Posts toEntity(){
        Posts posts = Posts.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .build();

        return posts;
    }
}
