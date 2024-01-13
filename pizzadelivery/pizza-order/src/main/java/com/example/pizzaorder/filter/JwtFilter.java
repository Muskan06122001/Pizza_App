package com.example.pizzaorder.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        String authHeader=httpServletRequest.getHeader("Authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer")){
            throw new ServletException("Token is Missing");
        }else {
            System.out.println("Authorization key"+authHeader);

            //Bearer    rteteeyeeue.yeuehenendnd...........................(we don't want Bearer we only want this token so we are using subString(7))
            String token=authHeader.substring(7);

            Claims claims= Jwts.parser().setSigningKey("jwtkey").parseClaimsJws(token).getBody();
            System.out.println("Claims from Token"+claims);
            httpServletRequest.setAttribute("customerEmailId",claims.get("customerEmailId"));
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
    }

