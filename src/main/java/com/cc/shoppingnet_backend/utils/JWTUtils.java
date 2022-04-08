package com.cc.shoppingnet_backend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * JWT工具类
 */
public class JWTUtils {

    private static final String SECRET_KEY = "A4iM2@14#da34hkf3a900iFb23*d010213";

    /**
     * 根据map中的信息生成Token
     */
    public static String createToken(Map<String, String> map) {
        String token = "";
        //创建7天的日期Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);
        try {
            JWTCreator.Builder builder = JWT.create();
            //设置payload,即携带的数据
            map.forEach(builder::withClaim);
            //设置过期时间及签名
            token = builder.withExpiresAt(calendar.getTime())
                    .sign(Algorithm.HMAC256(SECRET_KEY));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 根据Token获取payload
     */
    public static Map<String, Claim> getPayload(String token) {
        Map<String, Claim> map = null;
        try {
            map = JWT.decode(token).getClaims();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 验证Token
     * @return
     */
    public static DecodedJWT verify(String token) {
         return JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
    }





}
