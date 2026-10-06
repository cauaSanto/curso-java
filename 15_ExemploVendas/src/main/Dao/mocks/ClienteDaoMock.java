package main.Dao.mocks;

import main.Dao.IClienteDao;
import main.domain.Cliente;

import java.util.Collection;
import java.util.List;

public class ClienteDaoMock implements IClienteDao {


    @Override
    public boolean cadastrar(Cliente entity) {
        return true;
    }

    @Override
    public void excluir(Long codigo) {

    }

    @Override
    public void alterar(Cliente entity) {

    }

    @Override
    public Cliente consultar(Long codigo) {
        Cliente cliente = new Cliente();
        cliente.setCpf(codigo);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return List.of();
    }
}
