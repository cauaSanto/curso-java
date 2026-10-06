package main.service;

import main.Dao.IClienteDao;
import main.Dao.mocks.ClienteDaoMock;
import main.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ClienteServiceTest {


    private IClienteService clienteservice;

    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDao dao = new ClienteDaoMock();
        clienteservice = new ClienteService(dao);
    }
    //teste se beforeall funciona
    @BeforeEach
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("end");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(19999999999L);
    }

    @Test
    public void pesquisarCliente(){



        Cliente clienteConsultado = clienteservice.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente(){
        boolean retorno = clienteservice.salvar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){


        clienteservice.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente(){

        cliente.setNome("Rodrigo Pires");
        clienteservice.alterar(cliente);

        Assert.assertEquals("Rodrigo Pires",cliente.getNome());
    }


}