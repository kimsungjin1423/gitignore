package com.tj.edu.practice2.spring_ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Base64.Encoder;

@Component
public class Base64Encoder implements IEncoder {

    @Override
    public String encodeString(String message) {
        // Base64 인코딩 ///////////////////////////////////////////////////
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    @Override
    public byte[] encodeByte(String message) {
        // Base64 인코딩 ///////////////////////////////////////////////////
        Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(message.getBytes());

        return encodedBytes;
    }
}
