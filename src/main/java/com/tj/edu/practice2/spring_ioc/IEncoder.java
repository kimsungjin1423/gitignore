package com.tj.edu.practice2.spring_ioc;

public interface IEncoder {
    String encodeString(String message);
    byte[] encodeByte(String message);
}
