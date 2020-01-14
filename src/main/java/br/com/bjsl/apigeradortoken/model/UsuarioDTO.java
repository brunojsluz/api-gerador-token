package br.com.bjsl.apigeradortoken.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotNull(message = "O campo email é obrigatório")
    private String email;

    @NotNull(message = "O campo senha é obrigatório")
    private String senha;
}
