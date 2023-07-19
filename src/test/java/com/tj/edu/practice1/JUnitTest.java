package com.tj.edu.practice1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @DisplayName("basic-test1")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

//        Assertions.assertEquals(a + b, sum);  // 가독성이 안 좋은 코드
        assertThat(a + b).isEqualTo(sum);   // 가독성이 좋은 코드
//        assertThat(a + b).isNotEqualTo(sum);   // 가독성이 좋은 코드

        String aStr = "test1";
        assertThat(aStr).contains("est");   // 가독성이 좋은 코드
    }

    @DisplayName("basic-test2")
    @Test
    public void junitTest2() {
        int a = 1;
        int b = 3;
        int sum = 3;

        Assertions.assertEquals(a + b, sum);
    }
}
