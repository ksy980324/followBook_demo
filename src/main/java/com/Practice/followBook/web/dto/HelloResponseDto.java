package com.Practice.followBook.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Getter //선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성 (final이 없는 필드는 생성자에 포함X)
public class HelloResponseDto {

    private final String name;
    private final int amount;

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam int amount){
        //@RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        //@RequestParam("name") String name: 외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터 name에 저장
        return new HelloResponseDto(name, amount);
    }
}
