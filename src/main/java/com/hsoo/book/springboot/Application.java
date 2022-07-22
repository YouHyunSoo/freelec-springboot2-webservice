package com.hsoo.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행, 스프링부트는 내장 WAS 사용을 권장
                                                        // 이유는 언제어디서나 같은 환경에서 배포 가능하기때문에
    }
}
