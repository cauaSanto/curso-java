package main.Dao.generics;



import main.domain.Persistente;

import java.util.Collection;

public interface IgenericDao <T extends Persistente> {

    public boolean cadastrar(T entity);

    public  void excluir(Long codigo);

    public void alterar(T entity);

    public T consultar(Long codigo);

    public Collection<T> buscarTodos();


}
