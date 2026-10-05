package testes;

import org.junit.Assert;
import org.junit.Test;

public class SegundoTeste {

    @Test
    public void test2(){
        String nome = "Rodrigo";
        Assert.assertEquals("Rodrigo", nome);
    }
}
