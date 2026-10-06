package main.Dao;

import main.Dao.mocks.ClienteDaoMock;
import main.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteDaoTest {

    private IClienteDao clienteDao;

    private Cliente cliente;

    public ClienteDaoTest(){
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("end");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(19999999999L);
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){


        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente(){
        Boolean retorno = clienteDao.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente(){
        cliente.setNome("Rodrigo Pires");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Rodrigo Pires",cliente.getNome());
    }

}