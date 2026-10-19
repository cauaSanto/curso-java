package hibernateOGMMongoDB.dao;

import hibernateOGMMongoDB.domain.Curso;
import hibernateOGMMongoDB.domain.Matricula;

import java.util.List;

public interface IMatriculaDao {

    Matricula cadastrar(Matricula mat);

    Matricula buscarPorCodigoCurso(String codigoCurso);

    Matricula buscarPorCurso(Curso curso);

    Matricula buscarPorCodigoCursoCriteria(String codigoCurso);

    Matricula buscarPorCursoCriteria(Curso curso);

    List<Matricula> buscarTodos();

    void excluir(Matricula matricula);

}
