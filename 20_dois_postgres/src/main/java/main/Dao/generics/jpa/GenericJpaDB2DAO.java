package main.Dao.generics.jpa;

import main.domain.jpa.Persistente;

import java.io.Serializable;

public abstract class GenericJpaDB2DAO <T extends Persistente, E extends Serializable>
        extends GenericJpaDao<T,E> {

    public GenericJpaDB2DAO(Class<T> persistenteClass) {
        super(persistenteClass, "ExemploJPA2");
    }
}
