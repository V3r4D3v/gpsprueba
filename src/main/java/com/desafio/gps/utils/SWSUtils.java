package com.desafio.gps.utils;

import java.time.Instant;

import com.desafio.gps.config.SecurityConfig;

public class SWSUtils {
    public static String generateAuthorizationHeader(String id, String secretKey, String data) {
        long timestamp = Instant.now().getEpochSecond();
        String signature = SecurityConfig.generateSignature(id + secretKey + timestamp, secretKey);
        return "SWSAuth application=\"" + id + "\",signature=\"" + signature + "\",timestamp=\"" + timestamp + "\"";
    }
}
