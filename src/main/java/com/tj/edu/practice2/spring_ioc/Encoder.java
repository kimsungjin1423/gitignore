package com.tj.edu.practice2.spring_ioc;

/**
 * Encoder 종류는 굉장히 많다.
 * ex) Base64, UTF8, ASCII, URL인코딩....
 */
public class Encoder implements IEncoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    @Override
    public String encodeString(String message) {
        return iEncoder.encodeString(message);
    }

    @Override
    public byte[] encodeByte(String message) {
        return iEncoder.encodeByte(message);
    }
}
