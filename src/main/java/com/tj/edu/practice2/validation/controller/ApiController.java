package com.tj.edu.practice2.validation.controller;

import com.tj.edu.practice2.validation.model.dto.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@Validated
public class ApiController {


    // 모든 사용자 정보를 조회하는 API
    @GetMapping("/userAll")
    public String user() {
        return "";
    }

    // 특정 사용자 정보를 조회하는 API(/api/user?name=홍길동&age=30)
    @GetMapping("/user")
    public String user(@Size(min = 2) @RequestParam String name, @RequestParam int age) {
        return "이름: " + name + ", 나이: " + age;
    }

    // 사용자 정보를 등록하는 API
    @PostMapping("/user")
    // @Valid: Request 모델안에 있는 유효성 검사 annotation을 적용하기 위한 annotation
    // @RequestBody: http header안에 있는 content-type의 값을 application/json으로 제한하기 위한 annotation
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        System.out.println(user);

        if(bindingResult.hasErrors()) {
            // 백엔드에서 에러 코드를 감지하여 에러 로직을 핸들링이 가능
            System.out.println("에러코드가 나옴");

            List<ObjectError> listObjectError = bindingResult.getAllErrors();
            for (ObjectError objectError : listObjectError) {
                FieldError fieldError = (FieldError) objectError;

                System.out.println("field: " + fieldError.getField());
                System.out.println("message " + fieldError.getDefaultMessage());

                if (fieldError.getField().equals("name")) {
                    // 이름이 긴 경우 뒤의 텍스트를 cut해서 줄인표시(...)로 이름을 저장하는 코드
                    // ...
                }
            }
        }

        return ResponseEntity.ok(user);
    }
}
