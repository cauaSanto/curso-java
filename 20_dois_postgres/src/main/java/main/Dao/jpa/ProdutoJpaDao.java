package main.Dao.jpa;

import main.Dao.generics.jpa.GenericJpaDB1DAO;
import main.Dao.generics.jpa.GenericJpaDao;
import main.domain.jpa.ProdutoJpa;

public class ProdutoJpaDao extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDao {

    public ProdutoJpaDao(){
        super(ProdutoJpa.class);
    }
}
