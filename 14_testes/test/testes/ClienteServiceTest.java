package testes;

import org.junit.Assert;
import org.junit.Test;
import testes.dao.ClienteDao;
import testes.dao.ClienteDaoMock;
import testes.dao.IClienteDao;
import testes.service.ClienteService;

public class ClienteServiceTest {

    @Test
    public void salvarTest(){
        IClienteDao mock = new ClienteDaoMock();
        ClienteService service = new ClienteService(mock);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest(){
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso", retorno);
    }
}
