package com.forumapi.forumapi.dto;

import com.forumapi.forumapi.entity.Topico;
import com.forumapi.forumapi.entity.Usuario;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Builder
public class RespostaDTO {

    private Long id;
    private String mensagem;
    private Topico topico;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private Usuario autor;
    private Boolean solucao = false;



}
