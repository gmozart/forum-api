package com.forumapi.forumapi.repository;

import com.forumapi.forumapi.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
