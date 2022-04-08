package com.cc.shoppingnet_backend.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.cc.shoppingnet_backend.utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT拦截器
 * @author CC
 * 用于拦截所有需要检查JWT的请求
 */
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();
        // 验证token信息
        String token = request.getHeader("token");
        if (token == null || token.equals("")) {
            response.sendError(401, "请先登录");
        }else{
            try {
                //验证令牌
                JWTUtils.verify(token);
                //放行请求
                return true;
            } catch (SignatureVerificationException e) {
                map.put("error","无效签名");
            } catch (TokenExpiredException e){
                map.put("error","令牌已过期");
            } catch (AlgorithmMismatchException e){
                map.put("error","令牌算法不匹配");
            } catch (Exception e){
                map.put("error","令牌错误");
            }
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(map));
        }
        return false;
    }
}
