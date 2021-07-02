package com.sharefullcode.blopot.backendsavetoken.components;

import com.auth0.jwt.JWT;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager auth;

    LoginFilter(AuthenticationManager auth){
        this.auth = auth;
        setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
           LoginPojo login =  new ObjectMapper().readValue(request.getInputStream(),LoginPojo.class);
           UsernamePasswordAuthenticationToken objectCheck = new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword(),new ArrayList<>());
           return auth.authenticate(objectCheck);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        LoginPojo loginPojo = new LoginPojo();
        UserCustomize user = (UserCustomize) authResult.getPrincipal();

        List<String> lsAuthorization =List.copyOf(AuthorityUtils.authorityListToSet(user.getAuthorities()));

        String accessToken = JWT.create()
                .withSubject(user.getIdStaff())
                .withClaim(DefinationCommon.ROLE,lsAuthorization)
                .withClaim(DefinationCommon.AUTHENTICATED,Boolean.TRUE)
                .withClaim(DefinationCommon.FULLNAME,user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME_ACCESSTOKEN))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

        String refreshToken = JWT.create()
                .withSubject(user.getIdStaff())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME_REFERSHTOKEN))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET_REFRESH.getBytes()));

        loginPojo.setIduser(user.getIdStaff());
        loginPojo.setPassword(DefinationCommon.STRING_INITIAL);
        loginPojo.setAccessToken(accessToken);
        loginPojo.setRefreshToken(refreshToken);
        loginPojo.setRole(user.parseCollectionGrantedAuthorizationToString());
        loginPojo.setFullName(user.getUsername());
        loginPojo.setAuthenticated(Boolean.TRUE);
    }
}
