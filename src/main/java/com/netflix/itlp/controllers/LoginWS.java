package com.netflix.itlp.controllers;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.netflix.itlp.dao.LoginJDBC;
import com.netflix.itlp.models.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.PATCH })
public class LoginWS {
    @Autowired
    LoginJDBC repo;

    @PostMapping
    public ResponseEntity<?> iniciarSesion(@RequestBody Login login) {
        String token = "";
        /*
         * if (repo.consultarUsuario(login)) {
         * String email = login.getEmail();
         * token = getJWTToken(email);
         * return new ResponseEntity<String>(token, HttpStatus.OK);
         * } else {
         * return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
         * }
         */
        Login resultado = repo.consultarUsuario(login);
        if (resultado != null) {
            String email = login.getEmail();
            token = getJWTToken(email);
            return new ResponseEntity<String>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }

    private String getJWTToken(String username) {
        String secretKey = "tilinjr";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("netflixJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes())
                .compact();

        return "Sisoy " + token;
    }
}
