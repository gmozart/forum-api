package com.forumapi.forumapi.dto;

import com.forumapi.forumapi.entity.Curso;
import com.forumapi.forumapi.entity.Resposta;
import com.forumapi.forumapi.entity.Topico;
import com.forumapi.forumapi.entity.Usuario;
import com.forumapi.forumapi.enums.StatusTopico;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class TopicoDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao ;
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    private Usuario autor;
    private Curso curso;
    private List<Resposta> respostas;

    public static  TopicoDTO of(Topico topico){
        return TopicoDTO.builder()
                .id(topico.getId())
                .titulo(topico.getTitulo())
                .mensagem(topico.getMensagem())
                .dataCriacao(topico.getDataCriacao())
                .status(topico.getStatus())
                .autor(topico.getAutor())
                .curso(topico.getCurso())
                .respostas(topico.getRespostas())
                .build();
    }
    public static Topico of(TopicoDTO topicoDTO){
        return Topico.builder()
                .id(topicoDTO.getId())
                .titulo(topicoDTO.getMensagem())
                .mensagem(topicoDTO.getMensagem())
                .dataCriacao(topicoDTO.getDataCriacao())
                .status(topicoDTO.getStatus())
                .autor(topicoDTO.getAutor())
                .curso(topicoDTO.getCurso())
                .respostas(topicoDTO.getRespostas())
                .build();
    }
    public Optional<TopicoDTO> of(Optional<Topico> topico){
        return topico.stream().map(TopicoDTO::of).findAny();
    }
    public List<TopicoDTO> of(List<Topico> topicos){
        return topicos.stream().map(TopicoDTO::of).collect(Collectors.toList());
    }
}