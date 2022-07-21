package com.hsoo.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                    .param("name", name)    //param : API 테스트할 때 사용될 요청 파라미터를 설정, 값은 String만 허용
                    .param("amount", String.valueOf(amount)))   // 숫자/날짜 등의 데이터도 등록할 때에는 문자열로 변경해야함
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))    // jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드
                    .andExpect(jsonPath("$.amount", is(amount)));   //$ 기준으로 필드명을 명시..
    }
}
