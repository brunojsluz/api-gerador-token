package br.com.bjsl.apigeradortoken.service;

import br.com.bjsl.apigeradortoken.model.UsuarioDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class UsuarioService {

    private static final String DESCRICAO = "API de Autenticação para teste";

    @Value("${jwt.api.expiration}")
    private String secret;

    @Value("${jwt.api.expiration}")
    private String expiration;

    public String autenticar(UsuarioDTO usuario) {
        return Jwts.builder()
                .setIssuer(DESCRICAO)
                .setSubject(usuario.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(obterDataExpiracao())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private Date obterDataExpiracao() {
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(Long.parseLong(expiration));
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
