package hibernateOGMMongoDB.dao;

import hibernateOGMMongoDB.domain.Curso;

import java.util.List;

public interface ICursoDao {

    public Curso cadastrar(Curso curso);

    public void excluir(Curso cur);

    public List<Curso> buscarTodos();
}
