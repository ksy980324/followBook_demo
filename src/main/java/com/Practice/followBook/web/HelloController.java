package com.Practice.followBook.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌 ReseponseBody를 각 메소드마다 선언한 것을 한번에 사용할 수 있게 해줌
public class HelloController {
    @GetMapping("/hello") //Get 요청을 받을 수 있는 API를 만들어줌
    public String hello(){
        return "hello";
    }
}
