package com.Practice.followBook;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FollowBookApplicationTests {

	@Autowired //스프링이 관리하는 빈(Bean)을 주입
	private MockMvc mvc; //웹 API를 테스트할 때 상용, 스프링 MVC 테스트의 시작점

	@Test
	public void hello_반환() throws Exception{
		String hello = "hello";

		mvc.perform(get("/hello")) //MockMvc를 통해 /hello 주소로 HTTP GET 요청
				.andExpect(status().isOk()) //mvc.perform의 결과를 검증, HTTP Header의 Status를 검증
				.andExpect(content().string(hello)); //mvc.perform의 결과를 검증, 응답 본문의 내용을 검증
	}
	@Test
	public void helloDTD_반환() throws Exception{
		String name = "hello";
		int amount = 1000;

		mvc.perform(get("/hello/dto")
				.param("name", name) //API 테스트할 때 사용될 요청 파라미터를 설정, 오직 값은 String만 가능
				.param("amount", String.valueOf(amount))) //String이 아닌 값은 문자열로 변경해야함
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(name))) //JSON 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명을 명시
				.andExpect(jsonPath("$.amount", is(amount)));
	}
}
