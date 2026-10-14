package domain;


import dao.CursoDao;
import dao.generics.IgenericDao;
import org.junit.Assert;
import org.junit.Test;

public class CursoTest {

    private IgenericDao<Curso> cursoDao;

    public CursoTest(){
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar(){
        Curso curso = new Curso();

        curso.setCodigo("A1");
        curso.setDescricao("curso test");
        curso.setNome("curso de java");
        curso = cursoDao.cadastrar(curso);

        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());
    }
}