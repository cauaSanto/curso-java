package org.example.repository;

import org.example.domain.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICursoRepository extends MongoRepository<Curso, String> {

}