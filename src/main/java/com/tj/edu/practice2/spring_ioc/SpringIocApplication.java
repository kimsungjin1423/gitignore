package com.tj.edu.practice2.spring_ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class SpringIocApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);
        ApplicationContext ac = ApplicationContextProvider.getApplicationContext();

        String url = "https://www.naver.com";

        Encoder encoder = ac.getBean("base64Encode", Encoder.class);
        System.out.println("encoder객체: " + encoder);

        String resultStr = encoder.encodeString(url);
        byte[] resultByte = encoder.encodeByte(url);
        System.out.println(resultStr);
        System.out.println("spring-ioc연습 끝");
    }
}
//@Configuration(enforceUniqueMethods = false)
@Configuration
class AppConfig {
    @Bean("base64Encode")
    public Encoder encoder1(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }
    @Bean
    public Encoder encoder2(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}
