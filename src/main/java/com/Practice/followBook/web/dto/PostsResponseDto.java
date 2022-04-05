package com.Practice.followBook.web.dto;

import com.Practice.followBook.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        //Entity의 필드 중 일부만 사용해서 생성자로 Entity를 받아 필드에 값을 넣음, 굳이 모든 필드를 가진 생성자가 필요하지 않음으로 entity를 받아 처리
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
