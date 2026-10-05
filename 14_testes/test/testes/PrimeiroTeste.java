package testes;

import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTeste {

    @Test
    public void test(){
        String nome = "Rodrigo";
        Assert.assertEquals("Rodrigo", nome);
    }

    @Test
    public void testNotEquals(){
        String nome = "Rodrigo";
        Assert.assertNotEquals("Rodrigo1", nome);
    }

}
