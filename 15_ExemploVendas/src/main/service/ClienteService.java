package main.service;


import main.Dao.IClienteDao;
import main.domain.Cliente;

public class ClienteService implements IClienteService{


    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao){
        this.clienteDao = clienteDao;
    };




    @Override
    public boolean salvar(Cliente cliente) {

        return clienteDao.cadastrar(cliente);

    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDao.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDao.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) {
        clienteDao.alterar(cliente);
    }
}


