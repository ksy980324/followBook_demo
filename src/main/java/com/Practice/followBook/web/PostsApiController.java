package com.Practice.followBook.web;

import com.Practice.followBook.domain.posts.PostsRepository;
import com.Practice.followBook.service.posts.PostsService;
import com.Practice.followBook.web.dto.PostsResponseDto;
import com.Practice.followBook.web.dto.PostsSaveRequestDto;
import com.Practice.followBook.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    //생성자를 직접 안 쓰고 롬복 어노테이션을 사용한 이유: 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결하기 위해
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
