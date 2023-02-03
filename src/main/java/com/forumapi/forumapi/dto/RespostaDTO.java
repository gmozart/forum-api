package com.forumapi.forumapi.dto;

import com.forumapi.forumapi.entity.Resposta;
import com.forumapi.forumapi.entity.Topico;
import com.forumapi.forumapi.entity.Usuario;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class RespostaDTO {

    private Long id;
    private String mensagem;
    private Topico topico;
    private LocalDateTime dataCriacao;
    private Usuario autor;
    private Boolean solucao = false;


    public static RespostaDTO of(Resposta resposta){
        return RespostaDTO.builder()
                .id(resposta.getId())
                .mensagem(resposta.getMensagem())
                .dataCriacao(resposta.getDataCriacao())
                .autor(resposta.getAutor())
                .solucao(resposta.getSolucao())
                .build();
    }
    public static  Resposta of(RespostaDTO respostaDTO){
        return Resposta.builder()
                .id(respostaDTO.getId())
                .mensagem(respostaDTO.getMensagem())
                .dataCriacao(respostaDTO.getDataCriacao())
                .autor(respostaDTO.getAutor())
                .solucao(respostaDTO.getSolucao())
                .build();
    }
    public Optional<RespostaDTO> of(Optional<Resposta> resposta){
        return  resposta.stream().map(RespostaDTO::of).findAny();
    }
    public List<RespostaDTO> of(List<Resposta> respostas){
        return respostas.stream().map(RespostaDTO::of).collect(Collectors.toList());
    }
}