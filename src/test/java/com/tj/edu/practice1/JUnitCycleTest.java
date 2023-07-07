package com.tj.edu.practice1;

import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll이 실행됨");
    }

    @BeforeEach
    void beforeEach1() {
        System.out.println("@BeforeEach가 실행됨");
    }

    @Test
    void test1() {
        System.out.println("test1실행됨");
    }
    @Test
    void test2() {
        System.out.println("test2실행됨");
    }
    @Test
    void test3() {
        System.out.println("test3실행됨");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll이 실행됨");
    }

    @AfterEach
    void afterEach1() {
        System.out.println("@AfterEach가 실행됨");
    }
}
