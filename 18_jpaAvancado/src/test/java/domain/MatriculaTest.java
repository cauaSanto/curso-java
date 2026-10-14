package domain;

import dao.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;

public class MatriculaTest {

    private IMatriculaDao matriculaDao;

    private ICursoDao cursoDao;

    private IAlunoDao alunoDao;

    private IComputadorDao computadorDao;

    public MatriculaTest(){
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
        alunoDao = new AlunoDao();
        computadorDao = new ComputadorDao();
    }

    @Test
    public void cadastrar(){
        Curso curso = criarCurso("A1");
        Aluno aluno = criarAluno("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ativa");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat.setAluno(aluno);
        aluno.setMatricula(mat);
        matriculaDao.cadastrar(mat);

        Assert.assertNotNull(mat);
        Assert.assertNotNull(mat.getId());

        Matricula matBD = matriculaDao.buscarPorCodigoCurso(mat.getCodigo());
        Assert.assertNotNull(matBD);
        Assert.assertEquals(mat.getId(), matBD.getId());

        Matricula matBDObj = matriculaDao.buscarPorCurso(curso);
        Assert.assertNotNull(matBDObj);
        Assert.assertEquals(mat.getId(), matBDObj.getId());

        Matricula matBDCri = matriculaDao.buscarPorCursoCriteria(curso);
        Assert.assertNotNull(matBDCri);
        Assert.assertEquals(mat.getId(), matBDCri.getId());
    }

    private Curso criarCurso(String codigo){
        Curso curso = new Curso();

        curso.setCodigo(codigo);
        curso.setDescricao("curso test");
        curso.setNome("curso de java");
        return cursoDao.cadastrar(curso);
    }

    private Aluno criarAluno(String codigo){
        Aluno aluno = new Aluno();
        Computador comp = criarComputador("A1");
        Computador comp2 = criarComputador("A2");
        aluno.setCodigo(codigo);
        aluno.setNome("Rodrigo");
        aluno.add(comp);
        aluno.add(comp2);
        return alunoDao.cadastrar(aluno);
    }

    private Computador criarComputador(String codigo){
        Computador comp = new Computador();

        comp.setCodigo(codigo);
        comp.setDescricao("comp 1");
        return comp;
        //return computadorDao.cadastrar(comp);
    }
}