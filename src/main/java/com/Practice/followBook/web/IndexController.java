package com.Practice.followBook.web;

import com.Practice.followBook.config.auth.LoginUser;
import com.Practice.followBook.config.auth.dto.SessionUser;
import com.Practice.followBook.service.posts.PostsService;
import com.Practice.followBook.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
        model.addAttribute("posts", postsService.findAllDesc());
        //postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); -> @LoginUser만 사용해 세션 정보 가져올 수 있음
//        //CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장, 로그인 성공 시 httpSession,getAttribute("user")에서 값을 가져올 수 있음
        if(user != null) //세션에 저장된 값이 있을 때만 model에 userNmae으로 등록
            model.addAttribute("userName", user.getName());
        return "index";
        //머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정
        //앞의 경로: src/main/resources/templates 뒤의 파일 확장자: .mustache
        //즉 여기선 src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리
   }

   @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
   }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
