package com.Practice.followBook.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //Dao라고 불리는 DB Layer 접근자
    //JPA에선 Repository라고 부르며 인터페이스로 생성
    //단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동 생성
    //@Repository를 추가할 필요도 없음, Entity 클래스와 기본 Entity Repository는 함께 위치해야 함
    // -> 둘은 밀접한 관계이고 Entity 클래스는 기본 Repository 없이는 제대로 역할을 못 함
}
