package com.Practice.followBook.web.dto;

import com.Practice.followBook.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    //Entity 클래스와 유사한 Dto 클래스
    //절대로 Entity 클래스를 Request/Response 클래스로 사용해선 안됨
    //Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스, Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경
    //Entity 클래스가 변경되면 여러 클래스에 영향을 끼치지만, Request와 Response용 Dto는 View를 위한 클래스라 잦은 변경이 필요

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
