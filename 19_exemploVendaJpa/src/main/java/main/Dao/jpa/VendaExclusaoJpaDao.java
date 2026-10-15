package main.Dao.jpa;

import main.Dao.generics.jpa.GenericJpaDao;
import main.domain.jpa.VendaJpa;
import main.exceptions.DAOException;
import main.exceptions.TipoChaveNaoEncontradaException;
//somente para teses
public class VendaExclusaoJpaDao extends GenericJpaDao<VendaJpa, Long> implements IVendaJpaDao {

    public VendaExclusaoJpaDao(){
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("operação não permitida");
    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("operação não permitida");
    }

    @Override
    public VendaJpa consultarComCollection(Long id) {
        throw new UnsupportedOperationException("operação não permitida");
    }
}
