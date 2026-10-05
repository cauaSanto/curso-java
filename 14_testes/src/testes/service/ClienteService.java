package testes.service;

import testes.dao.ClienteDao;
import testes.dao.IClienteDao;

public class ClienteService {

    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao){
        //clienteDao = new ClienteDao();
        this.clienteDao = clienteDao;
    }

    public  String salvar(){

        clienteDao.salvar();
        return "Sucesso";
    }
}
