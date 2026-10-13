package domain;

import dao.CursoDao;
import dao.ICursoDao;
import dao.IMatriculaDao;
import dao.MatriculaDao;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;

public class MatriculaTest {

    private IMatriculaDao matriculaDao;

    public MatriculaTest(){
        matriculaDao = new MatriculaDao();
    }

    @Test
    public void cadastrar(){
        Matricula mat = new Matricula();

        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ativa");
        mat.setValor(2000d);
        matriculaDao.cadastrar(mat);

        Assert.assertNotNull(mat);
        Assert.assertNotNull(mat.getId());
    }
}