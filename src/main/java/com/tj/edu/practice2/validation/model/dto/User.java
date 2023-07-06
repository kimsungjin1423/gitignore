package com.tj.edu.practice2.validation.model.dto;

// 2.0 validation
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.NotNull;

// 3.0 validation
import com.tj.edu.practice2.validation.annotation.YearMonth;
import jakarta.validation.constraints.*;

public class User {
    @NotBlank(message = "이름은 꼭 필수적으로 작성해야 합니다.")
//    @Size(min = 2, max = 4, message = "이름은 2자에서 4자사이로만 작성이 가능합니다.")
    private String name;

    @Max(value = 200, message = "나이는 200을 넘을 수 없습니다.")
    @Min(value = 1, message = "나이는 0이하가 될 수 없습니다.")
    private int age;

    @Email
//    @Pattern(regexp = "^(.+)@(\\\\S+)$", message = "이메일 형식 오류")
    private String email;

    // 정규표현식을 이용한 패턴
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "폰 번호 오류")
    private String phoneNumber;

    @AssertTrue(message = "이메일의 끝 문자열은 .com으로 끝나야 합니다.")
    public boolean isTestSuccess() {
        // 별도의 로직
        if(email.endsWith(".com"))
            return true;

        return false;
    }

    // 생년월
//    @Size(min = 8, max = 8)
    // default 형식이 'YYYYMM' ->
//    @YearMonth(pattern = "yyMM")
    @YearMonth(message = "YYYYMM형식(숫자6자리)에 맞지 않습니다.")
    private String birth;       // YYYYMM


    // AssertFalse을 사용해서 별도의 로직을 구현을 해보세요~
//    @AssertFalse

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
