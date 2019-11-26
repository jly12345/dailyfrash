package com.work.daily.dailyfrash.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET = "56344fth-1b5f-4434-8c38-e68ed1ec1y2f";
    /**
     * 创建一个TOKEN
     * */
    public static String createToken(String username){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            Map<String, Object> map = new HashMap<>();

            ZonedDateTime nowDate =  ZonedDateTime.now();
            ZonedDateTime expireDate = nowDate.plus(2, ChronoUnit.HOURS);

            map.put("alg", "HS256");
            map.put("typ", "JWT");

            String token = JWT.create()
                    .withHeader(map)
                    .withClaim("username", username)
                    .withExpiresAt(Date.from(expireDate.toInstant()))
                    .withIssuedAt(new Date())
                    .sign(algorithm);
            return token;

        } catch (JWTCreationException exception){
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        if(token==null){
            return null;
        }
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * token是否过期
     * @return true：过期
     */
    public static boolean isTokenExpired(String token) {
        Date now = Date.from(Instant.now());
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(now);
    }


}
