package main.Dao.jpa;

import main.Dao.IProdutoDAO;
import main.Dao.generics.jpa.GenericJpaDao;
import main.domain.jpa.ClienteJpa;
import main.domain.jpa.ProdutoJpa;

public class ProdutoJpaDao extends GenericJpaDao<ProdutoJpa, Long> implements IProdutoJpaDao {

    public ProdutoJpaDao(){
        super(ProdutoJpa.class);
    }
}
