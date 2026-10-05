package testes;

import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTest {

    @Test
    public void TesteClienteTest(){
        TesteCliente cli = new TesteCliente();
        cli.adicionarNomes("Rodrigo");

        Assert.assertEquals("Rodrigo", cli.getNome());
    }
}
