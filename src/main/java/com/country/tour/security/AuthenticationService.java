package com.country.tour.security;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;

import com.country.tour.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Slf4j
public class AuthenticationService {

  static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds
  static final String SIGNINGKEY = "SecretKey";
  static final String PREFIX = "Bearer";

  static public void addToken(HttpServletResponse response, String username, String role) {
    String JwtToken = Jwts.builder()
        .setIssuer("CountryTourApp")
        .setSubject(username)
        .claim("scope", role)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
        .signWith(HS512, SIGNINGKEY)
        .compact();
    response.addHeader("Authorization", JwtToken);
//    response.addHeader("Authorization", PREFIX + " " + JwtToken);
    response.addHeader("Access-Control-Expose-Headers", "Authorization");
  }

  //decodeJWT
  static public Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    if (token != null) {

      try {
        Claims claims = Jwts.parser().setSigningKey(SIGNINGKEY)
            .parseClaimsJws(token.replace(PREFIX, ""))
            .getBody();

        User user = new User();
        user.setUsername(claims.getSubject());

        final Collection<? extends GrantedAuthority> authorities =
            Arrays.stream(claims.get("scope").toString().split(","))
                .map((role) -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        if (user != null) {
          return new UsernamePasswordAuthenticationToken(user, null, authorities);
        }

      } catch (Exception ex) {
        log.error("Failed to : {}", ex);
      }

    }
    return null;
  }
}