package main.Dao.jpa;

import main.Dao.generics.jpa.GenericJpaDB1DAO;
import main.Dao.generics.jpa.GenericJpaDao;
import main.domain.jpa.ClienteJpa;

public class ClienteJpaDao extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDao<ClienteJpa> {

    public ClienteJpaDao(){
        super(ClienteJpa.class);
    }
}
