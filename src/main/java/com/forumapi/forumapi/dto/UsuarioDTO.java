package com.forumapi.forumapi.dto;

import com.forumapi.forumapi.entity.Usuario;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public static UsuarioDTO of(Usuario usuario){
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .build();
    }
    public static Usuario of(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .id(usuarioDTO.getId())
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .build();
    }
    public Optional<UsuarioDTO> of(Optional<Usuario> usuario){
        return usuario.stream().map(UsuarioDTO::of).findAny();
    }
    public List<UsuarioDTO> of(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioDTO::of).collect(Collectors.toList());
    }
}
