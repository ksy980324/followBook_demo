package com.Practice.followBook.service.posts;

import com.Practice.followBook.domain.posts.Posts;
import com.Practice.followBook.domain.posts.PostsRepository;
import com.Practice.followBook.web.dto.PostsListResponseDto;
import com.Practice.followBook.web.dto.PostsResponseDto;
import com.Practice.followBook.web.dto.PostsSaveRequestDto;
import com.Practice.followBook.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    //생성자를 직접 안 쓰고 롬복 어노테이션을 사용한 이유: 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결하기 위해
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());;
        return id;
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) // = .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
        //postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환
    }
    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
        //JpaRepository에서 이미 delete 메소드를 지원
    }
}
