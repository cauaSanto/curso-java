package main.Dao.jpa;

import main.Dao.generics.jpa.GenericJpaDao;
import main.domain.jpa.ClienteJpa;

public class ClienteJpaDao extends GenericJpaDao<ClienteJpa, Long> implements IClienteJpaDao {

    public ClienteJpaDao(){
        super(ClienteJpa.class);
    }
}
