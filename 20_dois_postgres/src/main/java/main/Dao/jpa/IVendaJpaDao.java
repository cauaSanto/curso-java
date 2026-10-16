package main.Dao.jpa;

import main.Dao.generics.jpa.IGenericJpaDao;
import main.domain.jpa.VendaJpa;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDao extends IGenericJpaDao<VendaJpa, Long> {

    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    public VendaJpa consultarComCollection(Long id);

}
