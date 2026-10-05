package testes;

import org.junit.Assert;
import org.junit.Test;
import testes.dao.ContratoDao;
import testes.dao.IContratoDao;
import testes.dao.mocks.ContratoDaoMock;
import testes.service.ContratoService;
import testes.service.IContratoService;

public class ContratoServiceTest {

    @Test
    public void salvarTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno =  service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDados(){

        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno =  service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}
