package com.tj.edu.practice2.ioc;

public interface IEncoder {
    String encodeString(String message);
    byte[] encodeByte(String message);
}
