package Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dao.generic.GenericDao;
import domain.Cliente;
import domain.Produto;

public class ProdutoDao extends GenericDao<Produto> implements IProdutoDao{

    public ProdutoDao(){
        super();

    }


    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setNome(entity.getNome());
    }
}
