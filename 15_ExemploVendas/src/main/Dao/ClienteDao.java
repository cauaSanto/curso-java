package main.Dao;

import main.Dao.generics.GenericDao;
import main.domain.Cliente;

public class ClienteDao extends GenericDao<Cliente> implements IClienteDao {

   public ClienteDao(){
       super();
   }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
