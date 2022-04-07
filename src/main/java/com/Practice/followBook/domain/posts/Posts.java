package com.Practice.followBook.domain.posts;

import com.Practice.followBook.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가 (public Posts() {}와 같은 효과)
@Entity //테이블과 링크될 클래스임을 나타냄, JPA의 어노테이션
public class Posts extends BaseTimeEntity { //실제 DB의 테이블과 매칭될 클래스이며 Entity 클래스라고 함

    @Id //해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙을 나타냄, GenerationType.IDENTITY: auto_increment
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼을 나타내며 굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬림이 됨, 사용하는 이유는 추가로 변경한 옵션이 있을 때 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.author = author;
        this.content = content;
        this.title = title;
    }
    //Entity 클래스에는 절대 Setter 메소드를 만들지 않음
    //대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소를 추가해야만 함

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
