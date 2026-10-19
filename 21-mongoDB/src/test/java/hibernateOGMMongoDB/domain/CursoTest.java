package hibernateOGMMongoDB.domain;

import hibernateOGMMongoDB.dao.CursoDao;
import hibernateOGMMongoDB.dao.ICursoDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class CursoTest {
    private ICursoDao cursoDao;

    public CursoTest() {
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A2");
        curso.setDescricao("CURSO TESTE - Hibernate OGM");
        curso.setNome("Curso de Java Backend");
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }
}