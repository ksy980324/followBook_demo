package com.Practice.followBook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
    //update 기능에서 데이터베이스에 쿼리를 날리는 부분이 필요 없음 -> JPA의 영속성 컨텍스트 때문
    //영속성 컨텍스트: 엔티티를 영구 저장하는 환경
    //JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈림
    //JPA의 엔티티 매니저가 활성된 상태로 트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태
    //위 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영. 즉, Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없음 (더티 체킹)
}
