package com.tj.edu.practice2.ioc;

import java.net.URLEncoder;

public class UrlEncoder implements IEncoder {

    @Override
    public String encodeString(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public byte[] encodeByte(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8").getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
