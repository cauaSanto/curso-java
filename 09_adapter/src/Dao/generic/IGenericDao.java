package Dao.generic;

import domain.Persistente;

import java.util.Collection;

public interface IGenericDao <T extends Persistente>{

    public boolean cadastrar(T entity);
    public  void excluir(Long valor);
    public void alterar(T entity);
    public T consultar(Long valor);
    public Collection<T> buscarTodos();
}
