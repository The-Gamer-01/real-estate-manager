package com.hyx.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * JWT工具类.
 *
 * @author hyx
 **/

public class JwtUtil {
    
    /**
     * 过期时间.
     */
    private static final int TOKEN_EXPIRATION = 24 * 60 * 60 * 1000;
    
    /**
     * 秘钥.
     */
    private static final String TOKEN_SIGN_KEY = "kfcvme50";
    
    /**
     * JWT主题.
     */
    private static final String SUBJECT = "test";
    
    /**
     * 根据账号创建Token.
     * @param account 账号
     * @return token值.
     */
    public static String createToken(Long account) {
        return Jwts.builder()
                .setSubject(SUBJECT)
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                .claim("account", account)
                .signWith(SignatureAlgorithm.HS512, TOKEN_SIGN_KEY)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }
    
    public static Long getUserId(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Jws<Claims> claimsJwts = Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token);
        Claims claims = claimsJwts.getBody();
        Integer userId = (Integer) claims.get("account");
        return userId.longValue();
    }
}
