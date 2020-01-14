package br.com.bjsl.apigeradortoken.controller;

import br.com.bjsl.apigeradortoken.model.UsuarioDTO;
import br.com.bjsl.apigeradortoken.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String autenticar(@RequestBody @Valid UsuarioDTO usuario) {
        return usuarioService.autenticar(usuario);
    }


}
