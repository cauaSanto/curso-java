package main.Dao;

import main.Dao.generics.IgenericDao;
import main.domain.Venda;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IgenericDao<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
