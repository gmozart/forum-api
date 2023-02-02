package com.forumapi.forumapi.dto;

import com.forumapi.forumapi.entity.Curso;
import com.forumapi.forumapi.entity.Resposta;
import com.forumapi.forumapi.entity.Usuario;
import com.forumapi.forumapi.enums.StatusTopico;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TopicoDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    private Usuario autor;
    private Curso curso;
    private List<Resposta> respostas = new ArrayList<>();
}
