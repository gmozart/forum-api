package com.forumapi.forumapi.dto;

import com.forumapi.forumapi.entity.Curso;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class CursoDTO {

    private Long id;
    private String nome;
    private String categoria;

    public static CursoDTO of(Curso curso){
        return  CursoDTO.builder()
                .id(curso.getId())
                .nome(curso.getNome())
                .categoria(curso.getCategoria())
                .build();
    }

    public static  Curso of(CursoDTO cursoDTO){
        return  Curso.builder()
                .id(cursoDTO.getId())
                .nome(cursoDTO.getNome())
                .categoria(cursoDTO.getCategoria())
                .build();
    }

    public Optional<CursoDTO> of(Optional<Curso> curso){
        return curso.stream().map(CursoDTO::of).findAny();
    }

    public List<CursoDTO> of(List<Curso> cursos){
        return cursos.stream().map(CursoDTO::of).collect(Collectors.toList());
    }
}
