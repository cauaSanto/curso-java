package main.Dao.jpa;

import main.Dao.generics.jpa.IGenericJpaDao;
import main.domain.jpa.Persistente;

public interface IClienteJpaDao<T extends Persistente> extends IGenericJpaDao<T, Long>{
}
