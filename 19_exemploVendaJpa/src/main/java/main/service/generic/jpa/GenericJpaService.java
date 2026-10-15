package main.service.generic.jpa;

import main.Dao.generics.jpa.IGenericJpaDao;
import main.domain.Persistente;
import main.exceptions.DAOException;
import main.exceptions.MaisDeUmRegistroException;
import main.exceptions.TableException;
import main.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract class GenericJpaService<T extends Persistente, E extends Serializable> implements IGenericJpaService<T,E>{

    protected IGenericJpaDao<T,E> dao;

    public GenericJpaService(IGenericJpaDao<T,E> dao){
        this.dao = dao;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.consultar(id);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }
}
