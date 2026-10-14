package dao;

import dao.generics.IgenericDao;
import domain.Curso;
import domain.Matricula;

public interface IMatriculaDao extends IgenericDao<Matricula> {

    Matricula buscarPorCodigoCurso(String codigoCurso);

    Matricula buscarPorCurso(Curso curso);

    Matricula buscarPorCursoCriteria(Curso curso);
}
