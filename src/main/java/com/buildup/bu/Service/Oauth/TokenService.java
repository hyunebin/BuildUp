package com.buildup.bu.Service.Oauth;

import com.buildup.bu.Config.ConstructorProperties.SecretKeyConstructorProperties;
import com.buildup.bu.Exception.Code.UserErrorCode;
import com.buildup.bu.Exception.UserException;
import com.buildup.bu.Persist.Entity.Users;
import com.buildup.bu.Repository.UserRepository;
import com.buildup.bu.Security.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenService {
    private SecretKeyConstructorProperties skcp;
    private UserRepository userRepository;
    private String secretKey;
    @PostConstruct //의존성 주입이 이루어진 후 초기화를 수행하는 메서드이다.
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(skcp.getSecretKey().getBytes());
    }

    public Users findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()->new UserException(UserErrorCode.ALREADY_EXISTS_USER));
    }

    public Token generateToken(String uid, String role) {
        long tokenPeriod = 1000L * 60L * 10L;
        long refreshPeriod = 1000L * 60L * 60L * 24L * 30L * 3L;

        Claims claims = Jwts.claims().setSubject(uid);
        claims.put("role", role);

        //리프레쉬 토큰 , 일반 토큰 2개 발급
        Date now = new Date();
        return new Token(
                Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime() + tokenPeriod))
                        .signWith(SignatureAlgorithm.HS256, secretKey)
                        .compact(),
                Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime() + refreshPeriod))
                        .signWith(SignatureAlgorithm.HS256, secretKey)
                        .compact());
    }


    //토큰 만료 시간 검증
    public boolean verifyToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return claims.getBody()
                    .getExpiration()
                    .after(new Date());
        } catch (Exception e) {
            return false;
        }
    }


    public String getUid(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

}