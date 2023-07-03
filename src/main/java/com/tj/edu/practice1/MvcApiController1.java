package com.tj.edu.practice1;

import org.springframework.web.bind.annotation.*;

@RestController
public class MvcApiController1 {

    @GetMapping(value = "/test1")
    public String test1() {
        return "test1입니다!!!";
    }

    // POST 메소드는 데이터등록하는 메소드
    @PostMapping(value = "/post-test1")
    public String postTest1() {
        // jdk 17버전부터 지원
//        return """
//                {
//                    "name": "홍길동",
//                    "birth": "1990-05-05"
//                }
//               """;
        return "{ "
                + "\"name\" : \"홍길동\""
                + ", \"birth\": \"1990-05-05\" "
                + "}";
    }

    @PutMapping(value = "/put-test1")
    public String putTest1() {
        return "put은 업데이트 http 메소드 입니다.";
    }

    @DeleteMapping(value = "/delete-test1")
    public String deleteTest1() {
        return "delete은 삭제 http 메소드 입니다.";
    }
}
